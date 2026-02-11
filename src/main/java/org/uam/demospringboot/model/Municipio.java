package org.uam.demospringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="municipio")
@Getter
@Setter
public class Municipio extends EntityBase {
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name="departamento_id",referencedColumnName = "id")
    private Departamento departamento;
}
