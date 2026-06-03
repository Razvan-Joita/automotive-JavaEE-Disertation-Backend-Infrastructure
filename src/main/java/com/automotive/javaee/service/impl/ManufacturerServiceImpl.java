package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.ManufacturerDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.ManufacturerMapper;
import com.automotive.javaee.model.Manufacturer;
import com.automotive.javaee.repository.ManufacturerRepository;
import com.automotive.javaee.service.ManufacturerService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ManufacturerServiceImpl implements ManufacturerService {

    @Inject
    private ManufacturerRepository repository;

    @Inject
    private ManufacturerMapper mapper;

    @Override
    public List<ManufacturerDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ManufacturerDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer with id " + id + " was not found"));
    }

    @Override
    public ManufacturerDTO create(ManufacturerDTO dto) {
        Manufacturer entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ManufacturerDTO update(Long id, ManufacturerDTO dto) {
        Manufacturer entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer with id " + id + " was not found"));
        repository.delete(id);
    }
}
