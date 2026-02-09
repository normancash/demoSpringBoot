package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.model.Cliente;
import org.uam.demospringboot.repository.RepositoryCliente;

@Service
public class ServicioCliente extends GenericService<Cliente,RepositoryCliente>{

    protected ServicioCliente(RepositoryCliente repository) {
        super(repository);
    }
}
