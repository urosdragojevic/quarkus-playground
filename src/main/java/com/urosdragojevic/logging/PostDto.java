package com.urosdragojevic.logging;

import java.util.UUID;

public record PostDto(
        UUID id,
        String title
) {
}
