package org.uam.demospringboot.mapper;

import org.mapstruct.Mapper;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.model.Departamento;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    DepartamentoDTO toDTO(Departamento entity);

    Departamento toEntity(DepartamentoDTO dto);
}
