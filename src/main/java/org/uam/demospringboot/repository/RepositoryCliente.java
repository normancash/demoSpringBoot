package org.uam.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.demospringboot.model.Cliente;

import java.util.UUID;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, UUID> {
}
