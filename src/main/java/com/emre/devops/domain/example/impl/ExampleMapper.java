package com.emre.devops.domain.example.impl;


import com.emre.devops.domain.example.api.ExampleDto;

public class ExampleMapper {

    private ExampleMapper() {
    }

    public static ExampleDto toDto(Example example) {
        return new ExampleDto(
                example.getId(),
                example.getCreated(),
                example.getModified(),
                example.getName()
        );
    }

    public static Example toEntity(Example example, ExampleDto exampleDto) {
        example.setName(exampleDto.name());
        return example;
    }
}

    