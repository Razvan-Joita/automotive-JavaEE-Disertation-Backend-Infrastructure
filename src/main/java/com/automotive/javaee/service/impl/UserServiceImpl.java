
package com.automotive.javaee.service.impl;

import com.automotive.javaee.dto.UserDTO;
import com.automotive.javaee.exception.ResourceNotFoundException;
import com.automotive.javaee.mapper.UserMapper;
import com.automotive.javaee.model.User;
import com.automotive.javaee.repository.UserRepository;
import com.automotive.javaee.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository repository;

    @Inject
    private UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public UserDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " was not found"));
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " was not found"));
        mapper.updateEntity(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " was not found"));
        repository.delete(id);
    }
}
