
package com.automotive.javaee.service;

import com.automotive.javaee.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> findAll();
    InvoiceDTO findById(Long id);
    InvoiceDTO create(InvoiceDTO dto);
    InvoiceDTO update(Long id, InvoiceDTO dto);
    void delete(Long id);
}
