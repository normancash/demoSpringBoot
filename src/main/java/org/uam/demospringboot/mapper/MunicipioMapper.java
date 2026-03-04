package org.uam.demospringboot.mapper;


import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.dto.SucursalDTO;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.model.Municipio;
import org.uam.demospringboot.model.Sucursal;


@Mapper(config = CentralMapperConfig.class,
        uses = {
            EntityIdMapper.class,
            GenericFieldMapper.class,
        },
        imports = {Departamento.class}
        )
public interface MunicipioMapper extends GenericMapper<Municipio, MunicipioDTO> {

    @Override
    @Mapping(target="generico",source="entity"
         ,qualifiedByName = "toGenericDTO")
    @Mapping(target="idDepartamento",source="departamento")
    MunicipioDTO toDto(Municipio entity);

    @Override
    @Mapping(
            target= "id",source = "dto.generico.id"
    )
    @Mapping(target = "departamento",source="idDepartamento")
    Municipio toEntity(MunicipioDTO dto);

    @AfterMapping
    default void mapGenericFields(MunicipioDTO dto
            , @MappingTarget Municipio entity,
                                  GenericFieldMapper genericFieldMapper) {
        if (dto.generico() != null) {
            genericFieldMapper
                    .updateEntityFromGenericoDTO(dto.generico()
                            , entity);        }
    }


}
