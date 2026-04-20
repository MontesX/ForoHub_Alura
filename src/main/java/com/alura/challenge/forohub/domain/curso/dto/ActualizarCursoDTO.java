package com.alura.challenge.forohub.domain.curso.dto;

import com.alura.challenge.forohub.domain.curso.Categoria;

public record ActualizarCursoDTO(
        String name,
        Categoria categoria,
        Boolean activo) {
}
