package com.todo_ec.model.DTOs;

public class TodoUsuarioDTO {
    private Integer idUsuario;
    private String usuario;
    private String correo;
    private String contrasena;

    // Constructor vacío
    public TodoUsuarioDTO() {}

    // Constructor con parámetros
    public TodoUsuarioDTO(Integer idUsuario, String usuario, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
