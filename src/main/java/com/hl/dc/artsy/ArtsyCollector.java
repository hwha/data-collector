package com.hl.dc.artsy;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hl.dc.artsy.collector.ArtistCollector;
import com.hl.dc.artsy.common.TokenService;
import com.hl.dc.config.DIContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArtsyCollector {
    private static final Logger logger = LogManager.getLogger(ArtsyCollector.class);

    private static void initContainer() {
        logger.info("Initializing DI container...");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DIContainer.register(ObjectMapper.class, objectMapper);

        TokenService tokenService = new TokenService(DIContainer.get(ObjectMapper.class));
        DIContainer.register(TokenService.class, tokenService);
    }

    public static void main(String[] args) {
        logger.info("Hello, Artsy Collector!");
        initContainer();

        ArtistCollector collector = new ArtistCollector(DIContainer.get(ObjectMapper.class), DIContainer.get(TokenService.class));
        collector.getArtists();
    }
}
