package org.uam.demospringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.uam.demospringboot.dto.ClienteDTO;
import org.uam.demospringboot.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteToClienteDTO(Cliente entity);

    Cliente clienteDTOToCliente(ClienteDTO dto);
}
