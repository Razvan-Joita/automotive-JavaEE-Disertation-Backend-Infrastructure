package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.EmployeeDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.EmployeeMapper;
import com.automotive.javaee.model.Employee;
import com.automotive.javaee.repository.EmployeeRepository;
import com.automotive.javaee.service.EmployeeService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepository repository;

    @Inject
    private EmployeeMapper mapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " was not found"));
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " was not found"));
        repository.delete(id);
    }
}
