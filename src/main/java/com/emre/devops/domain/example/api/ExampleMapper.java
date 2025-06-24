package com.emre.devops.domain.example.api;

import com.emre.devops.core.utilis.PageUtil;
import com.emre.devops.domain.example.web.ExampleRequest;
import com.emre.devops.domain.example.web.ExampleResponse;
import org.springframework.data.domain.Page;


public class ExampleMapper {

    private ExampleMapper() {
    }

    public static ExampleDto toDto(ExampleRequest exampleRequest) {
        return ExampleDto.builder()
                .name(exampleRequest.name())
                .build();
    }

    public static ExampleResponse toResponse(ExampleDto exampleDto) {
        return ExampleResponse.builder()
                .id(exampleDto.id())
                .created(exampleDto.created())
                .modified(exampleDto.modified())
                .name(exampleDto.name())
                .build();
    }

    public static Page<ExampleResponse> toPageResponse(Page<ExampleDto> exampleDtos) {
        return PageUtil.pageToDto(exampleDtos, ExampleMapper::toResponse);
    }
}

    