package org.uam.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.service.IServiceSucursal;

import java.util.UUID;

@Repository
public interface RepositorySucursal extends JpaRepository<Sucursal, UUID> {
}
