package org.uam.demospringboot.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.uam.demospringboot.anotacion.CedulaValida;

@Entity
@Getter
@Setter
public class Usuario extends EntityBase{
    @NotBlank(message = "Primer nombre no puede estar vacio")
    private String primerNombre;
    private String segundoNombre;
    @NotBlank(message = "Primer apellido no puede estar vacio")
    private String primerApellido;
    private String segundoApellido;
    @Email(message = "el correo no es valido")
    private String email;
    @NotBlank(message = "Telefono no puede estar vacio")
    private String telefono;
    @NotBlank(message = "Direccion no puede estar vacio")
    private String direccion;
    @CedulaValida(message="La cedula no es valida")
    private String cedula;


}
