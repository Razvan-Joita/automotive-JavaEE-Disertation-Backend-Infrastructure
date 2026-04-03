package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.AppointmentDTO;
import com.automotive.javaee.model.Appointment;
import com.automotive.javaee.repository.VehicleRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppointmentMapper {
    @Inject
    private VehicleRepository vehicleRepository;

    public AppointmentDTO toDto(Appointment entity) {
        if (entity == null) { return null; }
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setVehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        return dto;
    }

    public Appointment toEntity(AppointmentDTO dto) {
        if (dto == null) { return null; }
        Appointment entity = new Appointment();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        if (dto.getVehicleId() != null) {
            entity.setVehicle(vehicleRepository.findById(dto.getVehicleId()).orElse(null));
        }
        return entity;
    }

    public void updateEntity(Appointment entity, AppointmentDTO dto) {
        entity.setDate(dto.getDate());
        entity.setVehicle(dto.getVehicleId() == null ? null : vehicleRepository.findById(dto.getVehicleId()).orElse(null));
    }
}