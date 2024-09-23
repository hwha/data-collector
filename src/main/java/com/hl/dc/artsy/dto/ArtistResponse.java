package com.hl.dc.artsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

public record ArtistResponse(
        Integer totalCount,
        @JsonProperty("_links")
        Links links,
        @JsonProperty("_embedded")
        ArtEmbedded embedded
) {
    public Boolean hasNext() {
        return this.links.next() != null && StringUtils.isNotBlank(this.links.next().href());
    }

    public String nextUrl() {
        if (this.links.next() == null) {
            return "";
        }
        return this.links.next().href();
    }
}
