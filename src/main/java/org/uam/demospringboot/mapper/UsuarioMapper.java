package org.uam.demospringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.dto.UsuarioDTO;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.model.Usuario;


@Mapper(config = CentralMapperConfig.class
        ,uses = {GenericFieldMapper.class}
)
public interface UsuarioMapper extends GenericMapper<Usuario, UsuarioDTO>{

    @Override
    @Mapping(target = "id", source = "dto.generico.id")
    Usuario toEntity(UsuarioDTO dto);

    @Override
    @Mapping(target="generico",source="entity")
    UsuarioDTO toDto(Usuario entity);
}


