package org.uam.demospringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comunidad")
@Getter
@Setter
public class Comunidad extends EntityBase {
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name="municipio_id",referencedColumnName = "id")
    private Municipio municipio;
}
