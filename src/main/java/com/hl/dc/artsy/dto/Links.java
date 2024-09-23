package com.hl.dc.artsy.dto;

public record Links(
        Href self,
        Href next,
        Href permalink,
        Href artworks,
        Href publishedArtworks,
        Href similarArtworks,
        Href similarContemporaryArtists,
        Href genes
) {
}
