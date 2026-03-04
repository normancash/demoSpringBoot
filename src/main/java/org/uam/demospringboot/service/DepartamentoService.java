package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.dto.DepartamentoDTO;
import org.uam.demospringboot.mapper.DepartamentoMapper;
import org.uam.demospringboot.model.Departamento;
import org.uam.demospringboot.repository.RepositoryDepartamento;

import java.util.List;
import java.util.UUID;
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
        Departamento d = departamentoMapper.toEntity(departamentoDTO);
        return departamentoMapper.toDto(repositoryDepartamento
                .save(d));
    }

    public DepartamentoDTO buscarById(UUID id) {
        return departamentoMapper.
                toDto(this.repositoryDepartamento
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Departamento no encontrado")));
    }

    public List<DepartamentoDTO> listar() {
          return departamentoMapper.toDtoList(repositoryDepartamento.findAll());
    }

    public DepartamentoDTO update(UUID id,DepartamentoDTO departamentoDTO) {
        DepartamentoDTO dto = buscarById(id);
        return departamentoMapper.toDto(repositoryDepartamento
                .save(departamentoMapper.toEntity(departamentoDTO)));
    }
}
