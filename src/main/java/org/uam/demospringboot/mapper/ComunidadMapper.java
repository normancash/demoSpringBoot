package org.uam.demospringboot.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.ComunidadDTO;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.model.Comunidad;
import org.uam.demospringboot.model.Municipio;

@Mapper(componentModel = "spring",
    uses = {
        GenericFieldMapper.class,
        EntityIdMapper.class,
    },
    imports = {Municipio.class}
)
public interface ComunidadMapper {

    @Mapping(source = "generico",target="entity",qualifiedByName = "toGenericDTO")
    @Mapping(target="idMunicipio",source="municipio")
    ComunidadDTO toDto(Comunidad entity);

    @Mapping(target="id",source="dto.generico.id")
    @Mapping(target="municipio",source="idMunicipio")
    Comunidad toEntity(ComunidadDTO dto);

    @AfterMapping
    default void mapGenericFields(ComunidadDTO dto
            , @MappingTarget Comunidad entity,
                                  GenericFieldMapper genericFieldMapper) {
        if (dto.generico() != null) {
            genericFieldMapper
                    .updateEntityFromGenericoDTO(dto.generico()
                            , entity);        }
    }

}
