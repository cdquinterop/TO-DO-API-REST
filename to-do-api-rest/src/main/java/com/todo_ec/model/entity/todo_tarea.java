package com.todo_ec.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class todo_tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tarea;

    @Column(length = 40)
    private String titulo;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha_inicio;

    @Column(nullable = false)
    private Date fecha_fin;

    public todo_tarea() {
    }

    public todo_tarea(String titulo, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

}
