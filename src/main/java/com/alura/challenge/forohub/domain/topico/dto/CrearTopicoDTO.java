package com.alura.challenge.forohub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearTopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long usuarioId,
        @NotNull Long cursoId) {
}
