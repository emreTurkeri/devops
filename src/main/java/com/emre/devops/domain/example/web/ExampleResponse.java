package com.emre.devops.domain.example.web;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ExampleResponse(UUID id, LocalDateTime created, LocalDateTime modified, String name) {
}
    