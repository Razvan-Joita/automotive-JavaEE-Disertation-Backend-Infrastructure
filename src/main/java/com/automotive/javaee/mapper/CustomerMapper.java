package com.automotive.javaee.mapper;

import com.automotive.javaee.dto.CustomerDTO;
import com.automotive.javaee.model.Customer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CustomerMapper {
    public CustomerDTO toDto(Customer entity) {
        if (entity == null) { return null; }
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) { return null; }
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public void updateEntity(Customer entity, CustomerDTO dto) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
    }
}