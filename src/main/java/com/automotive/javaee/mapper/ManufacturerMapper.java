package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.ManufacturerDTO;
import com.automotive.javaee.model.Manufacturer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ManufacturerMapper {
    public ManufacturerDTO toDto(Manufacturer entity) {
        if (entity == null) { return null; }
        ManufacturerDTO dto = new ManufacturerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public Manufacturer toEntity(ManufacturerDTO dto) {
        if (dto == null) { return null; }
        Manufacturer entity = new Manufacturer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        return entity;
    }

    public void updateEntity(Manufacturer entity, ManufacturerDTO dto) {
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
    }
}