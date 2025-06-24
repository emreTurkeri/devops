package com.emre.devops.domain.example.impl;


import com.emre.devops.core.enums.MessageCodes;
import com.emre.devops.core.exception.CoreException;
import com.emre.devops.core.utilis.PageUtil;
import com.emre.devops.domain.example.api.ExampleDto;
import com.emre.devops.domain.example.api.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository repository;

    @Override
    public Page<ExampleDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(repository.findAll(pageable), ExampleMapper::toDto);
    }

    @Override
    public ExampleDto getById(UUID id) {
        return repository.findById(id).map(ExampleMapper::toDto)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_NOT_FOUND, Example.class.getSimpleName(), id));
    }

    @Override
    @Transactional
    public ExampleDto save(ExampleDto dto) {
        return ExampleMapper.toDto(repository.save(ExampleMapper.toEntity(new Example(), dto)));
    }

    @Override
    @Transactional
    public ExampleDto update(UUID id, ExampleDto dto) {
        Example example = repository.findById(id).orElseThrow(() -> new CoreException(MessageCodes.ENTITY_NOT_FOUND, Example.class.getSimpleName(), id));
        return ExampleMapper.toDto(repository.save(setExample(example, dto)));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        var example = repository.findById(id).orElseThrow(() -> new CoreException(MessageCodes.ENTITY_NOT_FOUND, Example.class.getSimpleName(), id));
        repository.delete(example);
    }

    private Example setExample(Example example, ExampleDto dto) {
        example.setName(dto.name());
        return example;
    }
}

    