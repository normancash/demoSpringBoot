package org.uam.demospringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.service.MunicipioService;

import java.util.List;

@RestController
@RequestMapping("/municipio")
public class ControllerMunicipio {

    private final MunicipioService service;

    public ControllerMunicipio(MunicipioService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<MunicipioDTO> add(@RequestBody MunicipioDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> findAll() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping
    public ResponseEntity<MunicipioDTO> update(@RequestBody MunicipioDTO dto) {
        return ResponseEntity.ok(service.update(dto.generico().id(), dto));
    }
}


