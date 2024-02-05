package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.entity.TodoTarea;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.model.repository.TodoEstadoRepository;
import com.todo_ec.model.repository.TodoTareaRepository;
import com.todo_ec.service.TodoTareaService;
import com.todo_ec.service.TodoUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoTareaImpl implements TodoTareaService{

    @Autowired
    private TodoTareaRepository todoTareaRepository;

    @Transactional(readOnly = true)
    @Override
    public Iterable<TodoTarea> findAllTask() {
        return todoTareaRepository.findAll();
    }

    @Transactional
    @Override
    public TodoTarea saveTask(TodoTareaDTO todoTareaDTO) {
        TodoTarea todoTareaDb = new TodoTarea();
        BeanUtils.copyProperties(todoTareaDTO, todoTareaDb);
        return todoTareaRepository.save(todoTareaDb);
    }

    @Transactional
    @Override
    public TodoTarea updateTask(Integer id, TodoTareaDTO todoTareaDTO) {
        TodoTarea todoTarea = todoTareaRepository.findById(id).get();
        if(Objects.nonNull(todoTareaDTO.getTitulo()) && !"".equalsIgnoreCase(todoTareaDTO.getTitulo())){
            todoTarea.setTitulo(todoTareaDTO.getTitulo());
        }
        if (Objects.nonNull(todoTareaDTO.getDescripcion()) && !"".equalsIgnoreCase(todoTareaDTO.getDescripcion())){
            todoTarea.setDescripcion(todoTareaDTO.getDescripcion());
        }
        if (Objects.nonNull(todoTareaDTO.getFechaInicio()) && !"".equalsIgnoreCase(todoTareaDTO.getFechaInicio().toString())){
            todoTarea.setFechaInicio(todoTareaDTO.getFechaInicio());
        }
        if (Objects.nonNull(todoTareaDTO.getFechaFin()) && !"".equalsIgnoreCase(todoTareaDTO.getFechaFin().toString())){
            todoTarea.setFechaFin(todoTareaDTO.getFechaFin());
        }
        return todoTareaRepository.save(todoTarea);
    }

    @Transactional
    @Override
    public void deleteTaskById(Integer id) {
        todoTareaRepository.deleteById(id);
    }
}
