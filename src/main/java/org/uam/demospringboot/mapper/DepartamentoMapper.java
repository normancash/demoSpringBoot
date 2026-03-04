package org.uam.demospringboot.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.model.Departamento;

@Mapper(config = CentralMapperConfig.class
        ,uses = {GenericFieldMapper.class}
)
public interface DepartamentoMapper extends GenericMapper<Departamento,DepartamentoDTO> {

    @Override
    @Mapping(target="id",source="dto.generico.id")
    Departamento toEntity(DepartamentoDTO dto);

    @Override
    @Mapping(target="generico",source="entity")
    DepartamentoDTO toDto(Departamento entity);

    @AfterMapping
    default void mapGenericFields(
            DepartamentoDTO dto,
            @MappingTarget Departamento entity,
            GenericFieldMapper genericFieldMapper) {

        if (dto.generico() != null) {
            genericFieldMapper.updateEntityFromGenericoDTO(dto.generico(), entity);
        }
    }
}
