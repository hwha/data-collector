package com.hl.dc.artsy.domain;

import java.time.Instant;

public record XAppToken(
        String type,
        String token,
        Instant expiresAt
) {
}
