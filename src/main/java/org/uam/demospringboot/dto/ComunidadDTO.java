package org.uam.demospringboot.dto;

import java.util.UUID;

public record ComunidadDTO(
        UUID id,
        String nombre,
        UUID municipioId
) {
}
