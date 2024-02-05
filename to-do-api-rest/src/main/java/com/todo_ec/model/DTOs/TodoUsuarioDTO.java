package com.todo_ec.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class TodoUsuarioDTO implements Serializable {
    private Integer idUsuario;
    private String usuario;
    private String correo;
    private String contrasena;


}
