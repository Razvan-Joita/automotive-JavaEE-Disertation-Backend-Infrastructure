
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.VehicleDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.VehicleMapper;
import com.automotive.javaee.model.Vehicle;
import com.automotive.javaee.repository.VehicleRepository;
import com.automotive.javaee.service.VehicleService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private VehicleRepository repository;

    @Inject
    private VehicleMapper mapper;

    @Override
    public List<VehicleDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public VehicleDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " was not found"));
    }

    @Override
    public VehicleDTO create(VehicleDTO dto) {
        Vehicle entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " was not found"));
        repository.delete(id);
    }
}
