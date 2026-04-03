
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.CustomerDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.CustomerMapper;
import com.automotive.javaee.model.Customer;
import com.automotive.javaee.repository.CustomerRepository;
import com.automotive.javaee.service.CustomerService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerRepository repository;

    @Inject
    private CustomerMapper mapper;

    @Override
    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CustomerDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found"));
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found"));
        repository.delete(id);
    }
}
