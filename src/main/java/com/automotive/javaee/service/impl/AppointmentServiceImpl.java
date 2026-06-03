package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.AppointmentDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.AppointmentMapper;
import com.automotive.javaee.model.Appointment;
import com.automotive.javaee.repository.AppointmentRepository;
import com.automotive.javaee.service.AppointmentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AppointmentServiceImpl implements AppointmentService {

    @Inject
    private AppointmentRepository repository;

    @Inject
    private AppointmentMapper mapper;

    @Override
    public List<AppointmentDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public AppointmentDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with id " + id + " was not found"));
    }

    @Override
    public AppointmentDTO create(AppointmentDTO dto) {
        Appointment entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO dto) {
        Appointment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with id " + id + " was not found"));
        repository.delete(id);
    }
}
