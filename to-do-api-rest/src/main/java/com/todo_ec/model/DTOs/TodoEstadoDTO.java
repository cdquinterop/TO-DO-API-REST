package com.todo_ec.model.DTOs;

public class TodoEstadoDTO {
    private Integer idEstado;
    private String descripcion;

    // Constructor vacío
    public TodoEstadoDTO() {}

    // Constructor con parámetros
    public TodoEstadoDTO(Integer idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
