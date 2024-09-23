package com.hl.dc.artsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TestArtistResponse(
        Integer totalCount,
        @JsonProperty("_links")
        Links _links,
        @JsonProperty("_embedded")
        ArtEmbedded _embedded
) {
}
