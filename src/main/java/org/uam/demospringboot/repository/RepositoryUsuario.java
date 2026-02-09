package org.uam.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.demospringboot.model.Usuario;

import java.util.UUID;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, UUID> {
}
