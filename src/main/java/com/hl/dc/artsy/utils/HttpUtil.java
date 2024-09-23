package com.hl.dc.artsy.utils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class HttpUtil {
    private static final Logger logger = LogManager.getLogger(HttpUtil.class);
    private static final OkHttpClient client = new OkHttpClient();

    private HttpUtil() {
    }

    public static String executeGetRequest(String url, String token) {
        HttpUrl.Builder builder = HttpUrl.get(url).newBuilder();
        builder.addQueryParameter("total_count", "1");
        builder.addQueryParameter("size", "1000");
        Request request = new Request.Builder().url(builder.build())
                                               .method("GET", null)
                                               .header("X-XAPP-Token", token)
                                               .build();
        return execute(request);
    }

    public static String executePostFormRequest(String url, RequestBody requestBody) {
        Request request = new Request.Builder().url(url)
                                               .method("POST", requestBody)
                                               .build();
        return execute(request);
    }

    @NotNull
    private static String execute(Request request) {
        try (var response = client.newCall(request).execute()) {
            assert response.body() != null;

            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                logger.error("Failed to get response: {}", response.body());
                return "";
            }
        } catch (Exception e) {
            logger.error("Failed to get response", e);
            return "";
        }
    }
}
