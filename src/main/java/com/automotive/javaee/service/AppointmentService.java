
package com.automotive.javaee.service;

import com.automotive.javaee.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> findAll();
    AppointmentDTO findById(Long id);
    AppointmentDTO create(AppointmentDTO dto);
    AppointmentDTO update(Long id, AppointmentDTO dto);
    void delete(Long id);
}
