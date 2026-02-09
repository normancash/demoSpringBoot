package org.uam.demospringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="sucursal")
public class Sucursal extends EntityBase{
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message="La ubicacion no puede estar null")
    private String ubicacion;
    @NotBlank(message="La direccion no puede estar null")
    private String direccion;
    private String telefono;
    @Email(message = "El correo no es valido.")
    private String email;
}
