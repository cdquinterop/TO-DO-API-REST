package com.todo_ec.service;

import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.entity.TodoTarea;

import java.util.ArrayList;
import java.util.List;

public interface TodoTareaService {

    Iterable<TodoTarea> findAllTask();

    TodoTarea saveTask(TodoTareaDTO todoTareaDTO);

    TodoTarea updateTask(Integer id, TodoTareaDTO todoTareaDTO);

    void deleteTaskById(Integer id);

}
