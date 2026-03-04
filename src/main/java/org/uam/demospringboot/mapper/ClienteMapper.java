package org.uam.demospringboot.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.uam.demospringboot.dto.ClienteDTO;
import org.uam.demospringboot.model.Cliente;

@Mapper(config = CentralMapperConfig.class,
    uses = {GenericFieldMapper.class})
public interface ClienteMapper extends GenericMapper<Cliente, ClienteDTO> {

    @Override
    @Mapping(target="id",source="dto.generico.id")
    Cliente toEntity(ClienteDTO dto);

    @Override
    @Mapping(target = "generico",source="entity")
    ClienteDTO toDto(Cliente entity);


    @AfterMapping
    default void mapGenericFields(
            ClienteDTO dto,
            @MappingTarget Cliente entity,
            GenericFieldMapper genericFieldMapper) {

        if (dto.generico() != null) {
            genericFieldMapper.updateEntityFromGenericoDTO(dto.generico(), entity);
        }
    }
}
