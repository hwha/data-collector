package com.hl.dc.artsy.domain;

import java.time.Instant;
import java.util.List;

import com.hl.dc.artsy.dto.Links;

public record ArtsyArtist(
        String id,
        String slug,
        Instant createdAt,
        Instant updatedAt,
        String name,
        String sortableName,
        String gender,
        String biography,
        String birthday,
        String deathday,
        String hometown,
        String location,
        String nationality,
        Boolean targetSupply,
        List<String> imageVersions,
        Links _links
) {
}
