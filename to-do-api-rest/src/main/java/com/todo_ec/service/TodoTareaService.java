package com.todo_ec.service;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.entity.TodoTarea;
import com.todo_ec.model.entity.TodoUsuario;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

public interface TodoTareaService {

    Iterable<TodoTarea> findAllTask();

    TodoTareaDTO taskDTO(TodoTarea todoTarea);

    TodoTareaDTO saveTask(Integer idUsuario, TodoTareaDTO todoTareaDTO, Integer idEstado);

    TodoTarea updateTask(Integer id, TodoTareaDTO todoTareaDTO);

    void deleteTaskById(Integer id);

}
