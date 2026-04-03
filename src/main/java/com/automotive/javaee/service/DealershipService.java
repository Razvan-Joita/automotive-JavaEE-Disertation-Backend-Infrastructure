
package com.automotive.javaee.service;

import com.automotive.javaee.dto.DealershipDTO;

import java.util.List;

public interface DealershipService {
    List<DealershipDTO> findAll();
    DealershipDTO findById(Long id);
    DealershipDTO create(DealershipDTO dto);
    DealershipDTO update(Long id, DealershipDTO dto);
    void delete(Long id);
}
