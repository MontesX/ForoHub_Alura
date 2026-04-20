package com.alura.challenge.forohub.domain.curso;

import com.alura.challenge.forohub.domain.curso.dto.ActualizarCursoDTO;
import com.alura.challenge.forohub.domain.curso.dto.CrearCursoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//anotación de Lombok que llama a implementar getters
@Getter
//genera constructores sin argumentos para uso de Hibernate
@NoArgsConstructor
//anotación de Lombok que llama a implementar constructores con argumentos en las clases
@AllArgsConstructor
//crea la tabla en la base de datos
@Table(name = "cursos")
//Genera a la clase como una entidad de JPA
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCursoDTO crearCursoDTO) {
        this.name = crearCursoDTO.name();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true; //Automaticamente el curso estara activo.
    }

    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {

        if(actualizarCursoDTO.name() != null){
            this.name = actualizarCursoDTO.name();
        }
        if (actualizarCursoDTO.categoria() != null){
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null){
            this.activo = actualizarCursoDTO.activo();
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }



}
