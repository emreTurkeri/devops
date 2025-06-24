package com.emre.devops.domain.example.api;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ExampleDto(UUID id, LocalDateTime created,
                         LocalDateTime modified, String name) {
}
    