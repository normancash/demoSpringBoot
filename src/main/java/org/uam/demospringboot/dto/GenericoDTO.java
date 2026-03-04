package org.uam.demospringboot.dto;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

public record GenericoDTO(
        UUID id,
        String usuarioCreaccion,
        String usuarioActualizacion,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        Boolean restrictiva
) {
}
