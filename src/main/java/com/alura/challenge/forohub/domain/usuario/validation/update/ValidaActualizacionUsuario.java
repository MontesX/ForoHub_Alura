package com.alura.challenge.forohub.domain.usuario.validation.update;

import com.alura.challenge.forohub.domain.usuario.dto.ActualizarUsuarioDTO;
import com.alura.challenge.forohub.domain.usuario.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(ActualizarUsuarioDTO data) {
        if(data.email() != null){
            var emailDuplicado = repository.findByEmail(data.email());
            if(emailDuplicado != null){
                throw new ValidationException("El email ya está siendo usado");
            }
        }
    }
}
