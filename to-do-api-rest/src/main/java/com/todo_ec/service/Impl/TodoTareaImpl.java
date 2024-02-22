package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.entity.TodoTarea;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.model.repository.TodoEstadoRepository;
import com.todo_ec.model.repository.TodoTareaRepository;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import com.todo_ec.service.TodoTareaService;
import com.todo_ec.service.TodoUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TodoTareaImpl implements TodoTareaService{

    @Autowired
    private TodoTareaRepository todoTareaRepository;
    @Autowired
    private TodoUsuarioRepository todoUsuarioRepository;
    @Autowired
    private TodoEstadoRepository todoEstadoRepository;
    @Autowired
    private TodoEstadoImpl todoEstadoImpl;

    @Transactional(readOnly = true)
    @Override
    public Iterable<TodoTarea> findAllTask() {
        return todoTareaRepository.findAll();
    }

    @Override
    public TodoTareaDTO taskDTO(TodoTarea todoTarea) {
        TodoTareaDTO todoTareaDTO = TodoTareaDTO.builder()

                .idTarea(todoTarea.getIdTarea())
                .descripcion(todoTarea.getDescripcion())
                .titulo(todoTarea.getTitulo())
                .fechaInicio(todoTarea.getFechaInicio())
                .fechaFin(todoTarea.getFechaFin())
                .idUsuario(todoTarea.getTodoUsuario().getIdUsuario())
                .idEstado(todoEstadoImpl.statusDTO(todoTarea.getTodoEstado()).getIdEstado())
                .build();
        return todoTareaDTO;
    }

    @Transactional
    @Override
    public TodoTareaDTO saveTask(Integer idUsuario, TodoTareaDTO todoTareaDTO, Integer idEstado) {
        TodoTarea todoTareaDb = new TodoTarea();
        TodoEstado todoEstado = todoEstadoRepository.findById(idEstado).orElseThrow(
                () -> new NoSuchElementException("ID de estado no existe"));
        TodoUsuario todoUsuario = todoUsuarioRepository.findById(idUsuario).orElseThrow(
                () -> new NoSuchElementException("ID de usuario no existe"));
        BeanUtils.copyProperties(todoTareaDTO, todoTareaDb);
        todoTareaDb.setTodoUsuario(todoUsuario);
        todoTareaDb.setTodoEstado(todoEstado);
        //Saving new entity Data Base
        todoTareaDb = todoTareaRepository.save(todoTareaDb);
        return taskDTO(todoTareaDb);
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
