package org.uam.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.demospringboot.dto.MunicipioDTO;
import org.uam.demospringboot.model.Municipio;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryMunicipio extends JpaRepository<Municipio, UUID> {

    List<Municipio> findByDepartamento(UUID departamentoId);
}
