
package com.automotive.javaee.service;

import com.automotive.javaee.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> findAll();
    VehicleDTO findById(Long id);
    VehicleDTO create(VehicleDTO dto);
    VehicleDTO update(Long id, VehicleDTO dto);
    void delete(Long id);
}
