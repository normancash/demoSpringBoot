package org.uam.demospringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.config.OnCreate;
import org.uam.demospringboot.config.OnUpdate;
import org.uam.demospringboot.dto.GenericoDTO;
import org.uam.demospringboot.dto.UsuarioDTO;
import org.uam.demospringboot.mapper.UsuarioMapper;
import org.uam.demospringboot.model.Usuario;
import org.uam.demospringboot.service.IServiceUsuario;
import org.uam.demospringboot.service.ServiceUsuario;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    private final ServiceUsuario serviceUsuario;
    private final UsuarioMapper usuarioMapper;

    public ControllerUsuario(ServiceUsuario serviceUsuario, UsuarioMapper usuarioMapper) {
        this.serviceUsuario = serviceUsuario;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> listAllUsuario() {
        return ResponseEntity.ok(serviceUsuario.findAll()
                .stream()
                .map(
                   usuarioMapper::toDto
                ).toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody
                                               @Validated(OnCreate.class) Usuario usuario) {
        Usuario entity = serviceUsuario.create(usuario);
        return ResponseEntity.ok(usuarioMapper.toDto(entity));
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> update(@RequestBody @Validated(OnUpdate.class) Usuario usuario) {
        Usuario entity = serviceUsuario.update(usuario.getId(),usuario);
        return ResponseEntity.ok(usuarioMapper.toDto(entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.serviceUsuario.delete(id);
        return ResponseEntity.noContent().build();
    }

}
