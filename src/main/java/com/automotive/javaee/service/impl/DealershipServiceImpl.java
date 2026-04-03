
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.DealershipDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.DealershipMapper;
import com.automotive.javaee.model.Dealership;
import com.automotive.javaee.repository.DealershipRepository;
import com.automotive.javaee.service.DealershipService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class DealershipServiceImpl implements DealershipService {

    @Inject
    private DealershipRepository repository;

    @Inject
    private DealershipMapper mapper;

    @Override
    public List<DealershipDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public DealershipDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership with id " + id + " was not found"));
    }

    @Override
    public DealershipDTO create(DealershipDTO dto) {
        Dealership entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public DealershipDTO update(Long id, DealershipDTO dto) {
        Dealership entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership with id " + id + " was not found"));
        repository.delete(id);
    }
}
