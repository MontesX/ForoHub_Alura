package com.alura.challenge.forohub.domain.usuario.validation.create;

import com.alura.challenge.forohub.domain.usuario.dto.CrearUsuarioDTO;
import com.alura.challenge.forohub.domain.usuario.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario{


    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearUsuarioDTO data) {
        var usuarioDuplicado = repository.findByUsername(data.username());
        if(usuarioDuplicado != null){
            throw new ValidationException("El usuario ya existe.");
        }

        var emailDuplicado = repository.findByEmail(data.email());
        if(emailDuplicado != null){
            throw new ValidationException("El email ya existe.");
        }
    }

}
