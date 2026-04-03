
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.WarrantyDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.WarrantyMapper;
import com.automotive.javaee.model.Warranty;
import com.automotive.javaee.repository.WarrantyRepository;
import com.automotive.javaee.service.WarrantyService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class WarrantyServiceImpl implements WarrantyService {

    @Inject
    private WarrantyRepository repository;

    @Inject
    private WarrantyMapper mapper;

    @Override
    public List<WarrantyDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public WarrantyDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty with id " + id + " was not found"));
    }

    @Override
    public WarrantyDTO create(WarrantyDTO dto) {
        Warranty entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public WarrantyDTO update(Long id, WarrantyDTO dto) {
        Warranty entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty with id " + id + " was not found"));
        repository.delete(id);
    }
}
