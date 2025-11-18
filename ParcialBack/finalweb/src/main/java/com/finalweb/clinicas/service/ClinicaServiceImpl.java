package com.finalweb.clinicas.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalweb.clinicas.dto.ClinicaDTO;
import com.finalweb.clinicas.model.Clinica;
import com.finalweb.clinicas.repository.ClinicaRepository;

@Service
@Transactional
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository repo;
    private final ModelMapper mapper;

    public ClinicaServiceImpl(ClinicaRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClinicaDTO> listAll() {
        return repo.findAll().stream()
                .map(c -> mapper.map(c, ClinicaDTO.class))
                .toList();
    }

    @Override
    public ClinicaDTO create(ClinicaDTO dto) {
        Clinica entity = mapper.map(dto, Clinica.class);
        entity.setId(null); // asegurar INSERT
        Clinica saved = repo.save(entity);
        return mapper.map(saved, ClinicaDTO.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
