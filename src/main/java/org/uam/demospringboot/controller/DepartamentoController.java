package org.uam.demospringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> add(@RequestBody DepartamentoDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> findAll() {
        return ResponseEntity.ok(service.listar());
    }
}
