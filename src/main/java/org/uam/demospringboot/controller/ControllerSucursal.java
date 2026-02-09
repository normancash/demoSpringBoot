package org.uam.demospringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.dto.GenericoDTO;
import org.uam.demospringboot.dto.SucursalDTO;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.service.IServiceSucursal;
import org.uam.demospringboot.service.ServiceSucursal;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sucursal")
public class ControllerSucursal {

    private final ServiceSucursal serviceSucursal;

    public ControllerSucursal(ServiceSucursal serviceSucursal) {
        this.serviceSucursal = serviceSucursal;
    }


    @GetMapping("/all")
    public ResponseEntity<List<SucursalDTO>> getAll() {
        return ResponseEntity.ok(serviceSucursal.findAll().stream()
                .map(entity->
                   new SucursalDTO(
                           new GenericoDTO(entity.getId()),
                           entity.getNombre(),
                           entity.getUbicacion(),
                           entity.getDireccion(),
                           entity.getTelefono(),
                           entity.getEmail()
                   )
                ).toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<SucursalDTO> save(@RequestBody Sucursal sucursal) {
        Sucursal entity = serviceSucursal.create(sucursal);
        return ResponseEntity.ok(new SucursalDTO(
                new GenericoDTO(entity.getId()),
                entity.getNombre(),
                entity.getUbicacion(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getEmail()
        ) );
    }

    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> update(@RequestBody Sucursal sucursal) {
        Sucursal entity = serviceSucursal.update(sucursal.getId(),sucursal);
        return ResponseEntity.ok(new SucursalDTO(
                new GenericoDTO(entity.getId()),
                entity.getNombre(),
                entity.getUbicacion(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getEmail()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.serviceSucursal.delete(id);
        return ResponseEntity.noContent().build();
    }
}
