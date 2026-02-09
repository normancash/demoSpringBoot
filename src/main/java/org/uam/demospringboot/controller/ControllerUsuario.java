package org.uam.demospringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.config.OnCreate;
import org.uam.demospringboot.config.OnUpdate;
import org.uam.demospringboot.dto.GenericoDTO;
import org.uam.demospringboot.dto.UsuarioDTO;
import org.uam.demospringboot.model.Usuario;
import org.uam.demospringboot.service.IServiceUsuario;
import org.uam.demospringboot.service.ServiceUsuario;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    private final ServiceUsuario serviceUsuario;

    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> listAllUsuario() {
        return ResponseEntity.ok(serviceUsuario.findAll()
                .stream()
                .map(
                        entity->new UsuarioDTO(
                                new GenericoDTO(entity.getId()),
                                entity.getPrimerNombre(),
                                entity.getSegundoNombre(),
                                entity.getPrimerApellido(),
                                entity.getSegundoApellido(),
                                entity.getEmail(),
                                entity.getTelefono(),
                                entity.getDireccion(),
                                entity.getCedula()
                        )
                ).toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody
                                               @Validated(OnCreate.class) Usuario usuario) {
        Usuario entity = serviceUsuario.create(usuario);
        return ResponseEntity.ok(new UsuarioDTO(
                new GenericoDTO(entity.getId()),
                entity.getPrimerNombre(),
                entity.getSegundoNombre(),
                entity.getPrimerApellido(),
                entity.getSegundoApellido(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getCedula()
        ));
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> update(@RequestBody @Validated(OnUpdate.class) Usuario usuario) {
        Usuario entity = serviceUsuario.update(usuario.getId(),usuario);
        return ResponseEntity.ok(new UsuarioDTO(
                new GenericoDTO(entity.getId()),
                entity.getPrimerNombre(),
                entity.getSegundoNombre(),
                entity.getPrimerApellido(),
                entity.getSegundoApellido(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getCedula()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.serviceUsuario.delete(id);
        return ResponseEntity.noContent().build();
    }

}
