package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.repository.RepositorySucursal;

import java.util.List;

@Service
public class ServiceSucursal extends GenericService<Sucursal,RepositorySucursal> {

    protected ServiceSucursal(RepositorySucursal repository) {
        super(repository);
    }
}
