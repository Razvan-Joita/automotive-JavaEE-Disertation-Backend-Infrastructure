
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.InvoiceDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.InvoiceMapper;
import com.automotive.javaee.model.Invoice;
import com.automotive.javaee.repository.InvoiceRepository;
import com.automotive.javaee.service.InvoiceService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    private InvoiceRepository repository;

    @Inject
    private InvoiceMapper mapper;

    @Override
    public List<InvoiceDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public InvoiceDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice with id " + id + " was not found"));
    }

    @Override
    public InvoiceDTO create(InvoiceDTO dto) {
        Invoice entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public InvoiceDTO update(Long id, InvoiceDTO dto) {
        Invoice entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice with id " + id + " was not found"));
        repository.delete(id);
    }
}
