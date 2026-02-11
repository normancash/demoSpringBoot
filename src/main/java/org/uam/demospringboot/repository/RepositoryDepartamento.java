package org.uam.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.demospringboot.model.Departamento;

import java.util.UUID;

@Repository
public interface RepositoryDepartamento extends JpaRepository<Departamento, UUID> {
}
