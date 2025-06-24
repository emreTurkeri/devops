package com.emre.devops.domain.example.impl;


import com.emre.devops.domain.example.api.ExampleDto;

public class ExampleMapper {

    private ExampleMapper() {
    }

    public static ExampleDto toDto(Example example) {
        return ExampleDto.builder()
                .id(example.getId())
                .created(example.getCreated())
                .modified(example.getModified())
                .name(example.getName())
                .build();
    }

    public static Example toEntity(Example example, ExampleDto exampleDto) {
        example.setName(exampleDto.getName());
        return example;
    }
}

    