package com.todo_ec.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TODO_USUARIO", uniqueConstraints = {
        @UniqueConstraint( columnNames = "USUARIO" ),
        @UniqueConstraint(columnNames = "CORREO")
})
public class TodoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "USUARIO", nullable = false,  unique = true, length = 200)
    private String usuario;

    @Column(name = "CORREO", nullable = false,  unique = true, length = 200)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false, length = 200)
    private String contrasena;

    // Constructores, getters y setters

    public TodoUsuario() {
    }

    public TodoUsuario(Long idUsuario, String usuario, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }



}
