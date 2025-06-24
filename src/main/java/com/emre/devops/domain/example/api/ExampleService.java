package com.emre.devops.domain.example.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ExampleService {
    Page<ExampleDto> getAll(Pageable pageable);

    ExampleDto getById(UUID id);

    ExampleDto save(ExampleDto dto);

    ExampleDto update(UUID id, ExampleDto dto);

    void delete(UUID id);

}

    