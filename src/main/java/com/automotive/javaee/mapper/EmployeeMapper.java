package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.EmployeeDTO;
import com.automotive.javaee.model.Employee;
import com.automotive.javaee.repository.DealershipRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmployeeMapper {
    @Inject
    private DealershipRepository dealershipRepository;

    public EmployeeDTO toDto(Employee entity) {
        if (entity == null) { return null; }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setDealershipId(entity.getDealership() != null ? entity.getDealership().getId() : null);
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) { return null; }
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        if (dto.getDealershipId() != null) {
            entity.setDealership(dealershipRepository.findById(dto.getDealershipId()).orElse(null));
        }
        return entity;
    }

    public void updateEntity(Employee entity, EmployeeDTO dto) {
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setDealership(dto.getDealershipId() == null ? null : dealershipRepository.findById(dto.getDealershipId()).orElse(null));
    }
}