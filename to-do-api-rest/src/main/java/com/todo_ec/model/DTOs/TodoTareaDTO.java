package com.todo_ec.model.DTOs;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TodoTareaDTO implements Serializable {
    private Integer idTarea;
    private Integer idUsuario;
    private Integer idEstado;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;



}
