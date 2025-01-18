package com.aluracursos.foro.validaciones;

import com.aluracursos.foro.models.DatosRegistroRespuestaATopico;
import com.aluracursos.foro.repositorios.RespuestaRepository;
import com.aluracursos.foro.repositorios.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionMasDeDosRespuestasPorTopicoPorAutor implements IValidadorDeRespuestas {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RespuestaRepository respuestaRepository;

    public void validar(DatosRegistroRespuestaATopico datos,Long idTopico){
        var contadorRespuestasAlTopico=0;
        var emailUsuarioQueCreaLaRespuesta=datos.autor().correoElectronico();
        var autorQueCreaLaRespuesta=
                usuarioRepository.autorPorCorreoElectronicoOptional(emailUsuarioQueCreaLaRespuesta)
                        .orElseThrow(()->new EntityNotFoundException());

        var cantidadDeRespuestas=respuestaRepository.cantidadDeRespuestasPorAutorYTopico(autorQueCreaLaRespuesta.getId(),idTopico);

        if(cantidadDeRespuestas>2){
            throw new ValidacionExcepcion("no se puede responder mas de dos veces al topico");

        }
    }
}
