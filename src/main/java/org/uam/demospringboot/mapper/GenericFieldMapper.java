package org.uam.demospringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.uam.demospringboot.dto.GenericoDTO;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.model.EntityBase;

@Mapper(config = CentralMapperConfig.class)
public interface GenericFieldMapper {

    //Entity->DTO
    @Named("toGenericDTO")
    GenericoDTO toGenericoDTO(EntityBase entity);

    //DTO->Entity
    @Named("updateFromGenericDTO")
    void updateEntityFromGenericoDTO(GenericoDTO dto, @MappingTarget EntityBase entity);
}
