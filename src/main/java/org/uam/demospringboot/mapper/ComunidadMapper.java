package org.uam.demospringboot.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.ComunidadDTO;
import org.uam.demospringboot.model.Comunidad;
import org.uam.demospringboot.model.Municipio;

@Mapper(componentModel = "spring")
public interface ComunidadMapper {

    @Mapping(source = "municipio.id",target="municipioId")
    ComunidadDTO toDto(Comunidad entity);

    @Mapping(target="municipio",ignore = true)
    Comunidad toEntity(ComunidadDTO dto);

    @AfterMapping
    default void setMunicipio(ComunidadDTO dto, @MappingTarget Comunidad entity) {
        if (dto.municipioId() != null) {
            Municipio m = new Municipio();
            m.setId(dto.municipioId());
            entity.setMunicipio(m);
        }
    }

}
