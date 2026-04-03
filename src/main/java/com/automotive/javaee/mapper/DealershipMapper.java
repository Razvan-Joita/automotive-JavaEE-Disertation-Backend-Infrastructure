package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.DealershipDTO;
import com.automotive.javaee.model.Dealership;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DealershipMapper {
    public DealershipDTO toDto(Dealership entity) {
        if (entity == null) { return null; }
        DealershipDTO dto = new DealershipDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    public Dealership toEntity(DealershipDTO dto) {
        if (dto == null) { return null; }
        Dealership entity = new Dealership();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        return entity;
    }

    public void updateEntity(Dealership entity, DealershipDTO dto) {
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
    }
}