package com.todo_ec.model.DTOs;
import java.util.Date;

public class TodoTareaDTO {
    private Integer idTarea;
    private Integer idUsuario;
    private Integer idEstado;
    private String titulo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;

    // Constructor vacío
    public TodoTareaDTO() {}

    // Constructor con parámetros
    public TodoTareaDTO(Integer idTarea, Integer idUsuario, Integer idEstado, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        this.idTarea = idTarea;
        this.idUsuario = idUsuario;
        this.idEstado = idEstado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
