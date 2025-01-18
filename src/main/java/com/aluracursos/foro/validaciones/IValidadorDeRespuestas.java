package com.aluracursos.foro.validaciones;

import com.aluracursos.foro.models.DatosRegistroRespuestaATopico;

public interface IValidadorDeRespuestas {
    void validar(DatosRegistroRespuestaATopico datos,Long idTopico);
}
