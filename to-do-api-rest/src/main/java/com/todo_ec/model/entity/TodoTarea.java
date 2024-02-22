package com.todo_ec.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TODO_TAREA")
public class TodoTarea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA")
    private Integer idTarea;

    @Column(name = "TITULO", length = 300)
    private String titulo;

    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "FECHA_INICIO")
    private LocalDate fechaInicio;

    @Column(name = "FECHA_FIN")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private TodoUsuario todoUsuario;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private TodoEstado todoEstado;

}
