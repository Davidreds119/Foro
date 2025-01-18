package com.aluracursos.foro.models;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        int id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
