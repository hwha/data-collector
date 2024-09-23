package com.hl.dc.artsy.dto;

import java.util.List;

import com.hl.dc.artsy.domain.ArtsyArtist;

public record ArtEmbedded(
        List<ArtsyArtist> artists
) {
}
