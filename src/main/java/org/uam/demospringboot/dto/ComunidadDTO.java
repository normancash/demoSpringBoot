package org.uam.demospringboot.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ComunidadDTO(
        GenericoDTO generico,
        String nombre,
        UUID idMunicipio
) {
}
