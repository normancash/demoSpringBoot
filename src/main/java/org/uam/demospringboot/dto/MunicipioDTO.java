package org.uam.demospringboot.dto;

import java.util.UUID;

public record MunicipioDTO(
        UUID id,
        String nombre,
        UUID departamentoId
) {
}
