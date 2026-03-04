package org.uam.demospringboot.dto;

import java.util.UUID;

public record DepartamentoDTO(
        GenericoDTO generico,
        String nombre
) {
}
