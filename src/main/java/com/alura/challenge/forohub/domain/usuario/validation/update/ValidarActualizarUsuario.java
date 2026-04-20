package com.alura.challenge.forohub.domain.usuario.validation.update;

import com.alura.challenge.forohub.domain.usuario.dto.ActualizarUsuarioDTO;
import org.springframework.stereotype.Component;


public interface ValidarActualizarUsuario {

    void validate(ActualizarUsuarioDTO data);

}
