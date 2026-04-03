
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.ServiceRecordDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.ServiceRecordMapper;
import com.automotive.javaee.model.ServiceRecord;
import com.automotive.javaee.repository.ServiceRecordRepository;
import com.automotive.javaee.service.ServiceRecordService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ServiceRecordServiceImpl implements ServiceRecordService {

    @Inject
    private ServiceRecordRepository repository;

    @Inject
    private ServiceRecordMapper mapper;

    @Override
    public List<ServiceRecordDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ServiceRecordDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceRecord with id " + id + " was not found"));
    }

    @Override
    public ServiceRecordDTO create(ServiceRecordDTO dto) {
        ServiceRecord entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ServiceRecordDTO update(Long id, ServiceRecordDTO dto) {
        ServiceRecord entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceRecord with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceRecord with id " + id + " was not found"));
        repository.delete(id);
    }
}
