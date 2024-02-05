package com.todo_ec.model.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoEstadoDTO {
    private Integer idEstado;
    private String descripcion;
}
