package com.emre.devops.domain.example.web;


import com.emre.devops.core.rest.BaseController;
import com.emre.devops.core.rest.MetaResponse;
import com.emre.devops.core.rest.PageResponse;
import com.emre.devops.core.rest.Response;
import com.emre.devops.domain.example.api.ExampleMapper;
import com.emre.devops.domain.example.api.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("examples")
@RequiredArgsConstructor
public class ExampleController extends BaseController {

    private final ExampleService service;

    @GetMapping
    public Response<PageResponse<ExampleResponse>> getAllExamples(Pageable pageable) {
        return respond(ExampleMapper.toPageResponse(service.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public Response<ExampleResponse> getExampleById(@PathVariable UUID id) {
        return respond(ExampleMapper.toResponse(service.getById(id)));
    }

    @PostMapping
    public Response<ExampleResponse> createExample(@Valid @RequestBody ExampleRequest request) {
        return respond(ExampleMapper.toResponse(service.save(ExampleMapper.toDto(request))));
    }

    @PutMapping("/{id}")
    public Response<ExampleResponse> updateExample(@PathVariable UUID id, @RequestBody ExampleRequest request) {
        return respond(ExampleMapper.toResponse(service.update(id, ExampleMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteExample(@PathVariable UUID id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}

    