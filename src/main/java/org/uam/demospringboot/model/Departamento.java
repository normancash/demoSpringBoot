package org.uam.demospringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departamento")
@Getter
@Setter
public class Departamento extends EntityBase{

    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipios = new ArrayList<>();
}
