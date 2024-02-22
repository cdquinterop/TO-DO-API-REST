package com.todo_ec.model.DTOs;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class TodoUsuarioDTO implements Serializable {
    private Integer idUsuario;
    private String usuario;
    private String correo;
    private String contrasena;


}
