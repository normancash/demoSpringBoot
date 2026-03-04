package org.uam.demospringboot.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.dto.SucursalDTO;
import org.uam.demospringboot.model.Sucursal;

@Mapper(config = CentralMapperConfig.class,
        uses = {
            GenericFieldMapper.class
        })
public interface SucursalMapper extends GenericMapper<Sucursal, SucursalDTO> {



    @Override
    @Mapping(target="id",source="dto.generico.id")
    Sucursal toEntity(SucursalDTO dto);

    @Override
    @Mapping(target="generico",source="entity")
    SucursalDTO toDto(Sucursal entity);

    @AfterMapping
    default void mapGenericFields(SucursalDTO dto
            ,@MappingTarget Sucursal entity,
            GenericFieldMapper genericFieldMapper) {
        if (dto.generico() != null) {
            genericFieldMapper
                    .updateEntityFromGenericoDTO(dto.generico()
                            , entity);
        }
    }
}
