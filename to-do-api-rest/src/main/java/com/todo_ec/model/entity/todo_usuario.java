package com.todo_ec.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class todo_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usuario;
    @Column(nullable = false, unique = true)
    private String usuario;
    @Column(nullable = false, unique = true, length = 40)
    private String correo;
    @Column(nullable = false, unique = true, length = 40)
    private String contrasena;

    @OneToMany
    @JoinColumn(name = "id_tarea")
    private List<todo_tarea> listaTareas;

    public todo_usuario() {
    }

    public todo_usuario(String usuario, String correo, String contrasena) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public todo_usuario(String usuario, String correo, String contrasena, List<todo_tarea> listaTareas) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.listaTareas = listaTareas;
    }

}
