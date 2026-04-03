
package com.automotive.javaee.service;

import com.automotive.javaee.dto.PartDTO;

import java.util.List;

public interface PartService {
    List<PartDTO> findAll();
    PartDTO findById(Long id);
    PartDTO create(PartDTO dto);
    PartDTO update(Long id, PartDTO dto);
    void delete(Long id);
}
