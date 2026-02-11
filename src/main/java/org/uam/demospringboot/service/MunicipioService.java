package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.mapper.MunicipioMapper;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.model.Municipio;
import org.uam.demospringboot.repository.RepositoryDepartamento;
import org.uam.demospringboot.repository.RepositoryMunicipio;

import java.util.List;
import java.util.UUID;

@Service
public class MunicipioService {

    private final RepositoryMunicipio repositoryMunicipio;
    private final RepositoryDepartamento repositoryDepartamento;
    private final MunicipioMapper mapper;


    public MunicipioService(RepositoryMunicipio repositoryMunicipio, RepositoryDepartamento repositoryDepartamento, MunicipioMapper mapper) {
        this.repositoryMunicipio = repositoryMunicipio;
        this.repositoryDepartamento = repositoryDepartamento;
        this.mapper = mapper;
    }

    public MunicipioDTO crear(MunicipioDTO municipioDTO) {
        Departamento d = repositoryDepartamento.findById(municipioDTO.departamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        Municipio m = mapper.toEntity(municipioDTO);
        m.setDepartamento(d);
        return mapper.toDTO(repositoryMunicipio.save(m));
    }

    public List<MunicipioDTO> listarByDepartamento(UUID departamentoId) {
        return repositoryMunicipio.
                findByDepartamento(departamentoId)
                .stream()
                .map(mapper::toDTO)
                .toList();

    }

}
