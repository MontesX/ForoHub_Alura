package com.alura.challenge.forohub.infra.service;

import com.alura.challenge.forohub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Challenge")
                    .withSubject(usuario.getUsername())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaVencimiento())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Failed to generate token");
        }

    }

    public String getSubject(String token){
        if (token == null){
            throw new RuntimeException("Token is null");
        }

        DecodedJWT verifier = null;

        //validar firma
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("Challenge")
                    .build()
                    .verify(token);
            verifier.getSubject();

        }catch (JWTVerificationException e){
            System.out.println(e.toString()); ////Esto podría mejorarse para que devuelva "token no válido" o "token caducado" en el cuerpo y no en la consola
        }
        if (verifier.getSubject() == null){
            throw new RuntimeException("Invalid verifier");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaVencimiento() {
        return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-07:00"));
    }
}
