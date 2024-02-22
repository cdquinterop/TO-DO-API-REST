package com.todo_ec.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TODO_USUARIO", uniqueConstraints = {
        @UniqueConstraint( columnNames = "USUARIO" ),
        @UniqueConstraint(columnNames = "CORREO")
})
public class TodoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "USUARIO", nullable = false,  unique = true, length = 200)
    private String usuario;

    @Column(name = "CORREO", nullable = false,  unique = true, length = 200)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false, length = 200)
    private String contrasena;


}
