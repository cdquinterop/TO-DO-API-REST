package com.todo_ec.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TODO_USUARIO")
public class TodoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "USUARIO", nullable = false, length = 200)
    private String usuario;

    @Column(name = "CORREO", nullable = false, length = 200)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false, length = 200)
    private String contrasena;

    // Constructores, getters y setters

    public TodoUsuario() {
    }

    public TodoUsuario(Integer idUsuario, String usuario, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }



}
