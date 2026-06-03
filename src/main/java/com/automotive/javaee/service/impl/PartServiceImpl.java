package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.PartDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.PartMapper;
import com.automotive.javaee.model.Part;
import com.automotive.javaee.repository.PartRepository;
import com.automotive.javaee.service.PartService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class PartServiceImpl implements PartService {

    @Inject
    private PartRepository repository;

    @Inject
    private PartMapper mapper;

    @Override
    public List<PartDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public PartDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Part with id " + id + " was not found"));
    }

    @Override
    public PartDTO create(PartDTO dto) {
        Part entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public PartDTO update(Long id, PartDTO dto) {
        Part entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part with id " + id + " was not found"));
        repository.delete(id);
    }
}
