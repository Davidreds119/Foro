package com.aluracursos.foro.repositorios;

import com.aluracursos.foro.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    Optional<Curso> findByNombre(String nombre);
}
