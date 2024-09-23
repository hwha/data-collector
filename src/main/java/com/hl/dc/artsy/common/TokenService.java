package com.hl.dc.artsy.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hl.dc.artsy.domain.XAppToken;
import com.hl.dc.artsy.utils.HttpUtil;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenService {
    private static final Logger logger = LogManager.getLogger(TokenService.class);
    private static final String TARGET_HOST = "https://api.artsy.net";
    private static final String CLIENT_ID = "7a07a072ba38320effd3";
    private static final String CLIENT_SECRET = "6bc63fc193fe593445a26627168bb693";

    private final ObjectMapper objectMapper;

    public TokenService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getToken() {
        logger.info("Getting token...");
        String xAppTokenUrl = String.join("/", TARGET_HOST, "api", "tokens", "xapp_token");
        RequestBody requestBody = new FormBody.Builder().add("client_id", CLIENT_ID)
                                                        .add("client_secret", CLIENT_SECRET)
                                                        .build();

        String responseString = HttpUtil.executePostFormRequest(xAppTokenUrl, requestBody);

        try {
            XAppToken xappToken = objectMapper.readValue(responseString, XAppToken.class);
            return xappToken.token();
        } catch (JsonProcessingException e) {
            logger.error("Failed to get token", e);
            return "";
        }
    }
}
