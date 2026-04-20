package com.alura.challenge.forohub.domain.usuario.dto;

import com.alura.challenge.forohub.domain.usuario.Role;

public record ActualizarUsuarioDTO(
        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {
}
