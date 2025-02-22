package com.aluracursos.foro.models;



import jakarta.validation.constraints.Email;
import lombok.Getter;

public record DatosLoginUsuario(

        String nombre,
        @Email
        String correoElectronico,
        String contrasenia,
        Roles rol
) {

}
