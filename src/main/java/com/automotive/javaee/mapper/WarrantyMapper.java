package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.WarrantyDTO;
import com.automotive.javaee.model.Warranty;
import com.automotive.javaee.repository.VehicleRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class WarrantyMapper {
    @Inject
    private VehicleRepository vehicleRepository;

    public WarrantyDTO toDto(Warranty entity) {
        if (entity == null) { return null; }
        WarrantyDTO dto = new WarrantyDTO();
        dto.setId(entity.getId());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setVehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        return dto;
    }

    public Warranty toEntity(WarrantyDTO dto) {
        if (dto == null) { return null; }
        Warranty entity = new Warranty();
        entity.setId(dto.getId());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        if (dto.getVehicleId() != null) {
            entity.setVehicle(vehicleRepository.findById(dto.getVehicleId()).orElse(null));
        }
        return entity;
    }

    public void updateEntity(Warranty entity, WarrantyDTO dto) {
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setVehicle(dto.getVehicleId() == null ? null : vehicleRepository.findById(dto.getVehicleId()).orElse(null));
    }
}