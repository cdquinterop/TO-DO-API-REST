package com.todo_ec.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class todo_estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_estado;

    @Column(nullable = false, length = 40)
    private String descripcion;

    @OneToMany
    @JoinColumn(name = "id_estado")
    private List<todo_tarea> todoTarea;

    public todo_estado() {
    }

    public todo_estado(String descripcion, List<todo_tarea> todoTarea) {
        this.descripcion = descripcion;
        this.todoTarea = todoTarea;
    }
}
