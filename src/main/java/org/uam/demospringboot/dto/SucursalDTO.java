package org.uam.demospringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SucursalDTO(
     GenericoDTO genericoDTO,
     String nombre,
     String ubicacion,
     String direccion,
     String telefono,
     String email
) {
}
