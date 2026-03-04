package org.uam.demospringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Departamento extends EntityBase{
    @Column(unique=true)
    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipios = new ArrayList<>();
}
