
package com.automotive.javaee.service;

import com.automotive.javaee.dto.ServiceRecordDTO;

import java.util.List;

public interface ServiceRecordService {
    List<ServiceRecordDTO> findAll();
    ServiceRecordDTO findById(Long id);
    ServiceRecordDTO create(ServiceRecordDTO dto);
    ServiceRecordDTO update(Long id, ServiceRecordDTO dto);
    void delete(Long id);
}
