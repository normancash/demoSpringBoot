package org.uam.demospringboot.dto;

import org.uam.demospringboot.model.EntityBase;


import java.util.UUID;

public record MunicipioDTO (
        GenericoDTO generico,
        String nombre,
        UUID idDepartamento
) {
}
