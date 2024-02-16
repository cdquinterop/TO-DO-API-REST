package com.todo_ec.model.DTOs;

public class TodoLoginDTO {
    private String todoUsuario;
    private String todoContrasena;


    public TodoLoginDTO() {
    }

    public TodoLoginDTO(String todoUsuario, String todoContrasena) {
        this.todoUsuario = todoUsuario;
        this.todoContrasena = todoContrasena;
    }

    public String getTodoUsuario() {
        return todoUsuario;
    }

    public void setTodoUsuario(String todoUsuario) {
        this.todoUsuario = todoUsuario;
    }

    public String getTodoContrasena() {
        return todoContrasena;
    }

    public void setTodoContrasena(String todoContrasena) {
        this.todoContrasena = todoContrasena;
    }
}
