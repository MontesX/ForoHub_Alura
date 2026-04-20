package com.alura.challenge.forohub.domain.curso.repository;

import com.alura.challenge.forohub.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findAllByActivoTrue(Pageable pageable);
}
