package org.uam.demospringboot.dto;

import java.util.UUID;

public record DepartamentoDTO(
        UUID id,
        String nombre
) {
}
