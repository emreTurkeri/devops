package com.emre.devops.domain.example.web;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@ToString
public class ExampleResponse {
    private final UUID id;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final String name;
}
    