package com.todo_ec.service;

import com.todo_ec.model.DTOs.TodoUsuarioDTO;

import com.todo_ec.model.entity.TodoUsuario;


public interface TodoUsuarioService {

    //Crear y Actualizar Usuario
    TodoUsuario save(TodoUsuarioDTO todoUsuarioDTO);

    TodoUsuario update(TodoUsuarioDTO todoUsuarioDTO);

    Iterable<TodoUsuario> findAll();


    TodoUsuario findById(Integer id);


    void deleteById(Integer id);
}
