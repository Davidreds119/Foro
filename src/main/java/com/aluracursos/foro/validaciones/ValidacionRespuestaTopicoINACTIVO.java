package com.aluracursos.foro.validaciones;


import com.aluracursos.foro.models.DatosRegistroRespuestaATopico;
import com.aluracursos.foro.models.StatusTopico;
import com.aluracursos.foro.repositorios.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionRespuestaTopicoINACTIVO implements IValidadorDeRespuestas {

    @Autowired
    TopicoRepository topicoRepository;

    public void validar(DatosRegistroRespuestaATopico datos,Long idTopico){
        var idTopicoRespuesta=idTopico;
        var estadoDelTopico=topicoRepository.findById(idTopico).get().getStatus().equals(StatusTopico.INACTIVO);
        if(estadoDelTopico){
            throw new ValidacionExcepcion("el topico se encuentra inactivo. No se puede responder");
        }
    }
}
