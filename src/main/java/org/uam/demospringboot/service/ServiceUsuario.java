package org.uam.demospringboot.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.model.Usuario;
import org.uam.demospringboot.repository.RepositoryUsuario;

import java.util.List;

@Service
public class ServiceUsuario extends GenericService<Usuario,RepositoryUsuario> {

    protected ServiceUsuario(RepositoryUsuario repositoryUsuario) {
        super(repositoryUsuario);
    }
}
