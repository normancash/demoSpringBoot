package org.uam.demospringboot.dto;

public record UsuarioDTO(
      GenericoDTO generico,
      String primerNombre,
      String segundoNombre,
      String primerApellido,
      String segundoApellido,
      String email,
      String telefono,
      String direccion,
      String cedula
) {
}
