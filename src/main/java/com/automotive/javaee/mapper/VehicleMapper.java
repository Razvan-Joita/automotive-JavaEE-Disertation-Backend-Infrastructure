package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.VehicleDTO;
import com.automotive.javaee.model.Vehicle;
import com.automotive.javaee.repository.ManufacturerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VehicleMapper {
    @Inject
    private ManufacturerRepository manufacturerRepository;

    public VehicleDTO toDto(Vehicle entity) {
        if (entity == null) { return null; }
        VehicleDTO dto = new VehicleDTO();
        dto.setId(entity.getId());
        dto.setVin(entity.getVin());
        dto.setLicensePlate(entity.getLicensePlate());
        dto.setMake(entity.getMake());
        dto.setModel(entity.getModel());
        dto.setYear(entity.getYear());
        dto.setFuelType(entity.getFuelType());
        dto.setStatus(entity.getStatus());
        dto.setManufacturerId(entity.getManufacturer() != null ? entity.getManufacturer().getId() : null);
        return dto;
    }

    public Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) { return null; }
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setVin(dto.getVin());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setMake(dto.getMake());
        entity.setModel(dto.getModel());
        entity.setYear(dto.getYear());
        entity.setFuelType(dto.getFuelType());
        entity.setStatus(dto.getStatus());
        if (dto.getManufacturerId() != null) {
            entity.setManufacturer(manufacturerRepository.findById(dto.getManufacturerId()).orElse(null));
        }
        return entity;
    }

    public void updateEntity(Vehicle entity, VehicleDTO dto) {
        entity.setVin(dto.getVin());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setMake(dto.getMake());
        entity.setModel(dto.getModel());
        entity.setYear(dto.getYear());
        entity.setFuelType(dto.getFuelType());
        entity.setStatus(dto.getStatus());
        entity.setManufacturer(dto.getManufacturerId() == null ? null : manufacturerRepository.findById(dto.getManufacturerId()).orElse(null));
    }
}