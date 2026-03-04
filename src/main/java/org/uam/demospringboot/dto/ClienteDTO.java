package org.uam.demospringboot.dto;

import java.util.UUID;

public record ClienteDTO (
        GenericoDTO generico,
        String primerNombre,
        String primerApellido,
        String segundoNombre,
        String segundoApellido,
        String email,
        String telefono
) {
}
