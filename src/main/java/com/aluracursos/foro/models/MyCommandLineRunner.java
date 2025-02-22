package com.aluracursos.foro.models;

import com.aluracursos.foro.models.Argumentos;
import com.aluracursos.foro.repositorios.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    TopicoRepository topicoRepository;

    private Argumentos myComponent;

    public MyCommandLineRunner(Argumentos myComponent) {
        this.myComponent = myComponent;
    }

    @Override
    public void run(String... args) throws Exception {
        myComponent.printArgument();
        System.out.println("api rest para registro de topicos y respuestas con JAVA Spring y MySql");
    }
}
