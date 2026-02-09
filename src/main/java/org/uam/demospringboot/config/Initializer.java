package org.uam.demospringboot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.uam.demospringboot.model.Sucursal;
import org.uam.demospringboot.repository.RepositorySucursal;


@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {

    private final RepositorySucursal repositorySucursal;

    @Override
    public void run(String... args) throws Exception {
        /*Sucursal sucursal = new Sucursal();
        sucursal.setDireccion("Managua");
        sucursal.setNombre("Sucursal Managua");
        sucursal.setTelefono("900");
        sucursal.setEmail("algo");
        repositorySucursal.save(sucursal);*/
    }
}
