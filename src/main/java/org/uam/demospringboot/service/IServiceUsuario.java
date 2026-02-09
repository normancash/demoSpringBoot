package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.model.Usuario;

import java.util.List;

@Service
public interface IServiceUsuario {
    public List<Usuario> listAllUsuario();

    Usuario findUsuarioById(String id);

    Usuario save(Usuario usuario);

    void deleteUsuarioById(String id);
}
