package com.finalweb.clinicas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.finalweb.clinicas.dto.ClinicaDTO;
import com.finalweb.clinicas.service.ClinicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clinicas")
@Validated
public class ClinicaController {

    private final ClinicaService service;

    public ClinicaController(ClinicaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClinicaDTO>> getAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<ClinicaDTO> create(@Valid @RequestBody ClinicaDTO dto) {
        ClinicaDTO saved = service.create(dto);
        return ResponseEntity
                .created(URI.create("/api/clinicas/" + saved.getIdentificador()))
                .body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
