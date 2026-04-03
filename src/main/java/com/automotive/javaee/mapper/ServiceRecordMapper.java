package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.ServiceRecordDTO;
import com.automotive.javaee.model.ServiceRecord;
import com.automotive.javaee.model.Part;
import com.automotive.javaee.repository.EmployeeRepository;
import com.automotive.javaee.repository.PartRepository;
import com.automotive.javaee.repository.VehicleRepository;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceRecordMapper {
    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private PartRepository partRepository;

    @Inject
    private VehicleRepository vehicleRepository;

    public ServiceRecordDTO toDto(ServiceRecord entity) {
        if (entity == null) { return null; }
        ServiceRecordDTO dto = new ServiceRecordDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setDate(entity.getDate());
        dto.setVehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        dto.setMechanicId(entity.getMechanic() != null ? entity.getMechanic().getId() : null);
        if (entity.getParts() != null) {
            dto.setPartIds(entity.getParts().stream().map(item -> item.getId()).toList());
        }
        return dto;
    }

    public ServiceRecord toEntity(ServiceRecordDTO dto) {
        if (dto == null) { return null; }
        ServiceRecord entity = new ServiceRecord();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        if (dto.getVehicleId() != null) {
            entity.setVehicle(vehicleRepository.findById(dto.getVehicleId()).orElse(null));
        }
        if (dto.getMechanicId() != null) {
            entity.setMechanic(employeeRepository.findById(dto.getMechanicId()).orElse(null));
        }
        if (dto.getPartIds() != null) {
            List<Part> refs = new ArrayList<>();
            for (Long id : dto.getPartIds()) {
                partRepository.findById(id).ifPresent(refs::add);
            }
            entity.setParts(refs);
        }
        return entity;
    }

    public void updateEntity(ServiceRecord entity, ServiceRecordDTO dto) {
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setVehicle(dto.getVehicleId() == null ? null : vehicleRepository.findById(dto.getVehicleId()).orElse(null));
        entity.setMechanic(dto.getMechanicId() == null ? null : employeeRepository.findById(dto.getMechanicId()).orElse(null));
        List<Part> refs = new ArrayList<>();
        if (dto.getPartIds() != null) {
            for (Long id : dto.getPartIds()) {
                partRepository.findById(id).ifPresent(refs::add);
            }
        }
        entity.setParts(refs);
    }
}