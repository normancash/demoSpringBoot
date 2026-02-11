package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.mapper.DepartamentoMapper;
import org.uam.demospringboot.repository.RepositoryDepartamento;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    private final RepositoryDepartamento repositoryDepartamento;
    private final DepartamentoMapper departamentoMapper;


    public DepartamentoService(RepositoryDepartamento repositoryDepartamento, DepartamentoMapper departamentoMapper) {
        this.repositoryDepartamento = repositoryDepartamento;
        this.departamentoMapper = departamentoMapper;
    }

    public DepartamentoDTO crear(DepartamentoDTO departamentoDTO) {
        return departamentoMapper.toDTO(repositoryDepartamento
                .save(departamentoMapper.toEntity(departamentoDTO)));
    }

    public List<DepartamentoDTO> listar() {
        return repositoryDepartamento
                .findAll()
                .stream()
                .map(departamentoMapper::toDTO)
                .toList();
    }
}
