
package com.automotive.javaee.service;

import com.automotive.javaee.dto.WarrantyDTO;

import java.util.List;

public interface WarrantyService {
    List<WarrantyDTO> findAll();
    WarrantyDTO findById(Long id);
    WarrantyDTO create(WarrantyDTO dto);
    WarrantyDTO update(Long id, WarrantyDTO dto);
    void delete(Long id);
}
