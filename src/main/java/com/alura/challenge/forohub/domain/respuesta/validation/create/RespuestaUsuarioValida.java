package com.alura.challenge.forohub.domain.respuesta.validation.create;

import com.alura.challenge.forohub.domain.respuesta.dto.CrearRespuestaDTO;
import com.alura.challenge.forohub.domain.usuario.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuarioValida implements ValidarRespuestaCreada{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId());

        if(!usuarioExiste){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();

        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}
