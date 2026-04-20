package com.alura.challenge.forohub.domain.respuesta.validation.update;

import com.alura.challenge.forohub.domain.respuesta.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {
    void validate(ActualizarRespuestaDTO data, Long respuestaId);
}
