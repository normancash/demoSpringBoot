package org.uam.demospringboot.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cliente")
@Getter
@Setter
public class Cliente extends EntityBase {
    @NotEmpty(message = "No puede ser vacio")
    private String primerNombre;
    private String segundoNombre;
    @NotEmpty(message = "No puede ser vacio")
    private String primerApellido;
    private String segundoApellido;
    @Email(message = "El correo no tiene el formato indicado")
    private String email;
    /*@NotEmpty(message="No puede ser vacio")
    private String telefono;*/
    @ElementCollection()
    private List<Telefono> telefonos;

}
