
package com.automotive.javaee.service;

import com.automotive.javaee.dto.ManufacturerDTO;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerDTO> findAll();
    ManufacturerDTO findById(Long id);
    ManufacturerDTO create(ManufacturerDTO dto);
    ManufacturerDTO update(Long id, ManufacturerDTO dto);
    void delete(Long id);
}
