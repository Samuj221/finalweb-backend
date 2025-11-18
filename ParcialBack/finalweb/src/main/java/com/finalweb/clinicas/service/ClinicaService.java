package com.finalweb.clinicas.service;

import java.util.List;

import com.finalweb.clinicas.dto.ClinicaDTO;

public interface ClinicaService {
    List<ClinicaDTO> listAll();
    ClinicaDTO create(ClinicaDTO dto);
    void delete(Long id);
}
