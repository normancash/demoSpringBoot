package org.uam.demospringboot.service;

import org.springframework.stereotype.Service;
import org.uam.demospringboot.model.Sucursal;

import java.util.List;

@Service
public interface IServiceSucursal {

    public List<Sucursal> listAllSucursal();

    Sucursal findSucursalById(String id);

    Sucursal save(Sucursal sucursal);

    void deleteSucursalById(String id);
}
