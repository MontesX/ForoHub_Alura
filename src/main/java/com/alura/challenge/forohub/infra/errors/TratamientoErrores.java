package com.alura.challenge.forohub.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratamientoErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<?>> error400Handler(MethodArgumentNotValidException e){
        var error = e.getFieldErrors().stream().map(validacionErroresDatos::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?>error404Handler(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity<String> errorHandlerIntegrityValidation(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> errorHandlerBussinessValidation(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> invalidBodyHandler(Exception e) {
        return ResponseEntity.badRequest().body(
                "Algunas partes del cuerpo de la solicitud están expresadas incorrectamente");
    }

    private record validacionErroresDatos(String field, String error){
        public validacionErroresDatos(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
