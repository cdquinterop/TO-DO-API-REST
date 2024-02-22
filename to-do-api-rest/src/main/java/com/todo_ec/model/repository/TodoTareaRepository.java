package com.todo_ec.model.repository;

import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoTarea;
import com.todo_ec.model.entity.TodoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoTareaRepository extends CrudRepository <TodoTarea, Integer> {
}
