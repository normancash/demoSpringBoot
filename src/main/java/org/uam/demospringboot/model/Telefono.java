package org.uam.demospringboot.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Embeddable
public class Telefono {
    private String numero;
}
