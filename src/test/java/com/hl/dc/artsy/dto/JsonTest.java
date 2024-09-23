package com.hl.dc.artsy.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonTest {
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void writeAsString() throws JsonProcessingException {
        ArtistResponse artistResponse = new ArtistResponse(1,
                                                           new Links(new Href(
                                                                   "https://api.artsy.net/api/artists?cursor=00100011-hashtag%3A5f7e5561b6dbb4000d6316bc"),
                                                                     new Href(
                                                                             "https://api.artsy.net/api/artists?cursor=00100011-hashtag%3A5f7e5561b6dbb4000d6316bc"),
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null),
                                                           null);
        String s = objectMapper.writeValueAsString(artistResponse);
        Assertions.assertNotNull(s);
    }

    @Test
    void readValue() throws JsonProcessingException {
        String jsonString = "{\"total_count\":null,\"_links\":{\"self\":{\"href\":\"https://api.artsy.net/api/artists\"},\"next\":{\"href\":\"https://api.artsy.net/api/artists?cursor=00100011-hashtag%3A5f7e5561b6dbb4000d6316bc\"}},\"_embedded\":{\"artists\":[{\"id\":\"5723c839139b2113a8000619\",\"slug\":\"artist\",\"created_at\":\"2016-04-29T20:46:49+00:00\",\"updated_at\":\"2024-05-22T16:07:35+00:00\",\"name\":\"\\\"\",\"sortable_name\":\"\\\"\",\"gender\":null,\"biography\":\"\",\"birthday\":\"\",\"deathday\":\"\",\"hometown\":\"\",\"location\":\"\",\"nationality\":\"\",\"target_supply\":false,\"_links\":{\"self\":{\"href\":\"https://api.artsy.net/api/artists/5723c839139b2113a8000619\"},\"permalink\":{\"href\":\"https://www.artsy.net/artist/artist\"},\"artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5723c839139b2113a8000619\"},\"published_artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5723c839139b2113a8000619&published=true\"},\"similar_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5723c839139b2113a8000619\"},\"similar_contemporary_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5723c839139b2113a8000619&similarity_type=contemporary\"},\"genes\":{\"href\":\"https://api.artsy.net/api/genes?artist_id=5723c839139b2113a8000619\"}}},{\"id\":\"5723c909cd530e192700078c\",\"slug\":null,\"created_at\":\"2016-04-29T20:50:17+00:00\",\"updated_at\":\"2024-05-21T17:34:43+00:00\",\"name\":\"\\\"\",\"sortable_name\":\"\\\"\",\"gender\":null,\"biography\":\"\",\"birthday\":\"\",\"deathday\":\"\",\"hometown\":\"\",\"location\":\"\",\"nationality\":\"\",\"target_supply\":false,\"_links\":{\"self\":{\"href\":\"https://api.artsy.net/api/artists/5723c909cd530e192700078c\"},\"permalink\":{\"href\":\"https://www.artsy.net/artist/\"},\"artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5723c909cd530e192700078c\"},\"published_artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5723c909cd530e192700078c&published=true\"},\"similar_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5723c909cd530e192700078c\"},\"similar_contemporary_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5723c909cd530e192700078c&similarity_type=contemporary\"},\"genes\":{\"href\":\"https://api.artsy.net/api/genes?artist_id=5723c909cd530e192700078c\"}}},{\"id\":\"64f20ac90308f2000a53dfdd\",\"slug\":\"64f20ac90308f2000a53dfdd\",\"created_at\":\"2023-09-01T16:01:15+00:00\",\"updated_at\":\"2024-05-22T16:31:24+00:00\",\"name\":\"_\",\"sortable_name\":\"_\",\"gender\":null,\"biography\":\"\",\"birthday\":\"\",\"deathday\":\"\",\"hometown\":\"\",\"location\":\"\",\"nationality\":\"\",\"target_supply\":false,\"_links\":{\"self\":{\"href\":\"https://api.artsy.net/api/artists/64f20ac90308f2000a53dfdd\"},\"permalink\":{\"href\":\"https://www.artsy.net/artist/64f20ac90308f2000a53dfdd\"},\"artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=64f20ac90308f2000a53dfdd\"},\"published_artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=64f20ac90308f2000a53dfdd&published=true\"},\"similar_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=64f20ac90308f2000a53dfdd\"},\"similar_contemporary_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=64f20ac90308f2000a53dfdd&similarity_type=contemporary\"},\"genes\":{\"href\":\"https://api.artsy.net/api/genes?artist_id=64f20ac90308f2000a53dfdd\"}}},{\"id\":\"66470f46926bc8000e21abd8\",\"slug\":\"66470f46926bc8000e21abd8\",\"created_at\":\"2024-05-17T08:03:20+00:00\",\"updated_at\":\"2024-05-21T17:55:15+00:00\",\"name\":\"\uD835\uDDEB\uD835\uDE02 \uD835\uDDD6\uD835\uDDF5\uD835\uDDF2\uD835\uDDFB\uD835\uDE06\uD835\uDDEE\uD835\uDDFB\uD835\uDDF4\",\"sortable_name\":\"\uD835\uDDD6\uD835\uDDF5\uD835\uDDF2\uD835\uDDFB\uD835\uDE06\uD835\uDDEE\uD835\uDDFB\uD835\uDDF4 \uD835\uDDEB\uD835\uDE02\",\"gender\":\"male\",\"biography\":\"\",\"birthday\":\"1966\",\"deathday\":\"\",\"hometown\":\"China\",\"location\":\"China\",\"nationality\":\"Chinese\",\"target_supply\":false,\"image_versions\":[\"square\",\"large\",\"four_thirds\",\"tall\"],\"_links\":{\"thumbnail\":{\"href\":\"https://d32dm0rphc51dk.cloudfront.net/-SPW331rByGf_SbdwpWsEA/square.jpg\"},\"image\":{\"href\":\"https://d32dm0rphc51dk.cloudfront.net/-SPW331rByGf_SbdwpWsEA/{image_version}.jpg\",\"templated\":true},\"self\":{\"href\":\"https://api.artsy.net/api/artists/66470f46926bc8000e21abd8\"},\"permalink\":{\"href\":\"https://www.artsy.net/artist/66470f46926bc8000e21abd8\"},\"artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=66470f46926bc8000e21abd8\"},\"published_artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=66470f46926bc8000e21abd8&published=true\"},\"similar_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=66470f46926bc8000e21abd8\"},\"similar_contemporary_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=66470f46926bc8000e21abd8&similarity_type=contemporary\"},\"genes\":{\"href\":\"https://api.artsy.net/api/genes?artist_id=66470f46926bc8000e21abd8\"}}},{\"id\":\"5f7e5561b6dbb4000d6316bc\",\"slug\":\"00100011-hashtag\",\"created_at\":\"2020-10-07T23:55:13+00:00\",\"updated_at\":\"2024-07-26T18:18:12+00:00\",\"name\":\"00100011 [Hashtag]\",\"sortable_name\":\"00100011 [Hashtag]\",\"gender\":null,\"biography\":\"\",\"birthday\":\"\",\"deathday\":\"\",\"hometown\":\"\",\"location\":\"\",\"nationality\":\"\",\"target_supply\":false,\"image_versions\":[\"square\",\"four_thirds\",\"tall\",\"large\"],\"_links\":{\"thumbnail\":{\"href\":\"https://d32dm0rphc51dk.cloudfront.net/QYaZG81lG_POkocw0g3XcA/square.jpg\"},\"image\":{\"href\":\"https://d32dm0rphc51dk.cloudfront.net/QYaZG81lG_POkocw0g3XcA/{image_version}.jpg\",\"templated\":true},\"self\":{\"href\":\"https://api.artsy.net/api/artists/5f7e5561b6dbb4000d6316bc\"},\"permalink\":{\"href\":\"https://www.artsy.net/artist/00100011-hashtag\"},\"artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5f7e5561b6dbb4000d6316bc\"},\"published_artworks\":{\"href\":\"https://api.artsy.net/api/artworks?artist_id=5f7e5561b6dbb4000d6316bc&published=true\"},\"similar_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5f7e5561b6dbb4000d6316bc\"},\"similar_contemporary_artists\":{\"href\":\"https://api.artsy.net/api/artists?similar_to_artist_id=5f7e5561b6dbb4000d6316bc&similarity_type=contemporary\"},\"genes\":{\"href\":\"https://api.artsy.net/api/genes?artist_id=5f7e5561b6dbb4000d6316bc\"}}}]}}";
        TestArtistResponse artistResponse = objectMapper.readValue(jsonString, TestArtistResponse.class);
        Assertions.assertNotNull(artistResponse);
    }
}