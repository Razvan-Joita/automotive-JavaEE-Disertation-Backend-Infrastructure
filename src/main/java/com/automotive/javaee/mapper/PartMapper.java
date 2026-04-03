package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.PartDTO;
import com.automotive.javaee.model.Part;
import com.automotive.javaee.model.ServiceRecord;
import com.automotive.javaee.repository.ServiceRecordRepository;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PartMapper {
    @Inject
    private ServiceRecordRepository serviceRecordRepository;

    public PartDTO toDto(Part entity) {
        if (entity == null) { return null; }
        PartDTO dto = new PartDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPartNumber(entity.getPartNumber());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        if (entity.getServiceRecords() != null) {
            dto.setServiceRecordIds(entity.getServiceRecords().stream().map(item -> item.getId()).toList());
        }
        return dto;
    }

    public Part toEntity(PartDTO dto) {
        if (dto == null) { return null; }
        Part entity = new Part();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPartNumber(dto.getPartNumber());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        if (dto.getServiceRecordIds() != null) {
            List<ServiceRecord> refs = new ArrayList<>();
            for (Long id : dto.getServiceRecordIds()) {
                serviceRecordRepository.findById(id).ifPresent(refs::add);
            }
            entity.setServiceRecords(refs);
        }
        return entity;
    }

    public void updateEntity(Part entity, PartDTO dto) {
        entity.setName(dto.getName());
        entity.setPartNumber(dto.getPartNumber());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        List<ServiceRecord> refs = new ArrayList<>();
        if (dto.getServiceRecordIds() != null) {
            for (Long id : dto.getServiceRecordIds()) {
                serviceRecordRepository.findById(id).ifPresent(refs::add);
            }
        }
        entity.setServiceRecords(refs);
    }
}