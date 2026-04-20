package com.alura.challenge.forohub.domain.usuario.repository;

import com.alura.challenge.forohub.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByUsername(String username);

    UserDetails findByEmail(String email);

    Page<Usuario> findAllByEnabledTrue(Pageable pageable);

    @SuppressWarnings("null")
    Usuario getReferenceById(Long id);

    @SuppressWarnings("null")
    Page<Usuario> findAll(Pageable pageable);

    Usuario getReferenceByUsername(String username);

    Boolean existsByUsername(String username);
}
