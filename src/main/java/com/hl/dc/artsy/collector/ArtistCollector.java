package com.hl.dc.artsy.collector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hl.dc.artsy.common.TokenService;
import com.hl.dc.artsy.dto.ArtistResponse;
import com.hl.dc.artsy.exception.FailedCreateStorageException;
import com.hl.dc.artsy.exception.FailedSaveFileException;
import com.hl.dc.artsy.exception.JsonParseException;
import com.hl.dc.artsy.utils.HttpUtil;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArtistCollector {
    private static final Logger logger = LogManager.getLogger(ArtistCollector.class);
    private static final String TARGET_HOST = "https://api.artsy.net";
    private static final String VAULT_PATH = "vault/artsy/artists";

    private final ObjectMapper objectMapper;
    private final TokenService tokenService;

    public ArtistCollector(ObjectMapper objectMapper, TokenService tokenService) {
        this.objectMapper = objectMapper;
        this.tokenService = tokenService;

        Path vaultPath = Paths.get(VAULT_PATH);

        try {
            if (Files.exists(vaultPath)) {
                FileUtils.cleanDirectory(vaultPath.toFile());
                logger.info("Cleaned directory: {}", VAULT_PATH);
            } else {
                Files.createDirectories(vaultPath);
            }
        } catch (IOException e) {
            throw new FailedCreateStorageException(e);
        }
    }

    public void getArtists() {
        logger.info("Getting artists...");
        String xAppToken = tokenService.getToken();
        String artistsUrl = String.join("/", TARGET_HOST, "api", "artists");

        try {
            int index = 0;
            boolean hasNext;

            do {
                String responseString = HttpUtil.executeGetRequest(artistsUrl, xAppToken);
                this.saveToFile(String.format("artists-%d.json", index), responseString);
                index++;

                ArtistResponse artistResponse = this.objectMapper.readValue(responseString, ArtistResponse.class);
                hasNext = artistResponse.hasNext();
                artistsUrl = artistResponse.nextUrl();
                logger.info("Next URL: {}", artistsUrl);
            } while (hasNext);

        } catch (JsonProcessingException e) {
            throw new JsonParseException(e);
        }
    }


    private void saveToFile(String fileName, String contents) {
        try {
            Path filePath = Paths.get(VAULT_PATH, fileName);
            Files.writeString(filePath, contents);
        } catch (IOException e) {
            throw new FailedSaveFileException(e);
        }
    }
}
