package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.InvoiceDTO;
import com.automotive.javaee.model.Invoice;
import com.automotive.javaee.repository.ServiceRecordRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InvoiceMapper {
    @Inject
    private ServiceRecordRepository serviceRecordRepository;

    public InvoiceDTO toDto(Invoice entity) {
        if (entity == null) { return null; }
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setServiceRecordId(entity.getServiceRecord() != null ? entity.getServiceRecord().getId() : null);
        return dto;
    }

    public Invoice toEntity(InvoiceDTO dto) {
        if (dto == null) { return null; }
        Invoice entity = new Invoice();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        if (dto.getServiceRecordId() != null) {
            entity.setServiceRecord(serviceRecordRepository.findById(dto.getServiceRecordId()).orElse(null));
        }
        return entity;
    }

    public void updateEntity(Invoice entity, InvoiceDTO dto) {
        entity.setAmount(dto.getAmount());
        entity.setServiceRecord(dto.getServiceRecordId() == null ? null : serviceRecordRepository.findById(dto.getServiceRecordId()).orElse(null));
    }
}