package org.uam.demospringboot.mapper;

import org.aspectj.lang.annotation.AfterReturning;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.model.Municipio;

@Mapper(componentModel = "spring")
public interface MunicipioMapper {

    @Mapping(source="departamento.id",target="departamentoId")
    MunicipioDTO toDTO(Municipio entity);

    @Mapping(target="departamento",ignore = true)
    Municipio toEntity(MunicipioDTO dto);

    @AfterMapping
    default void setDepartamento(MunicipioDTO dto, @MappingTarget Municipio entity) {
        if (dto.departamentoId() != null) {
            Departamento d = new Departamento();
            d.setId(dto.departamentoId());
            entity.setDepartamento(d);
        }
    }

}
