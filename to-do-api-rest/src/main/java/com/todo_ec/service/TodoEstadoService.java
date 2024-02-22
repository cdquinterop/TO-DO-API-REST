package com.todo_ec.service;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.entity.TodoUsuario;

public interface TodoEstadoService {
    TodoEstado save (TodoEstadoDTO todoEstadoDTO);
    TodoEstado update(TodoEstadoDTO todoEstadoDTO);

    Iterable<TodoEstado> findAll();

    TodoEstado findById(Integer id);

    TodoEstadoDTO statusDTO(TodoEstado todoEstado);

    void deleteById(Integer id);
}
