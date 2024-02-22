package com.todo_ec.controller;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoTareaDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoTarea;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class TodoTareaController {

    @Autowired
    private TodoTareaService todoTareaService;

    @GetMapping("tarea")
    public Iterable<TodoTarea> findAllTask() {
        return todoTareaService.findAllTask();
    }

    //Create User
    @PostMapping("tarea/{idUsuario}/{idEstado}")
    public ResponseEntity<?> saveTask(@PathVariable Integer idUsuario, @RequestBody TodoTareaDTO tareaDTO, @PathVariable Integer idEstado) {
        TodoTareaDTO savedTask = todoTareaService.saveTask(idUsuario, tareaDTO, idEstado);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PutMapping("tarea/{id}")
    public TodoTarea updateTask(@PathVariable Integer id, @RequestBody TodoTareaDTO todoTareaDTO) {
        return todoTareaService.updateTask(id, todoTareaDTO);
    }

    @DeleteMapping("tarea/{id}")
    public String deleteTaskById(@PathVariable Integer id) {
        todoTareaService.deleteTaskById(id);
        return "Successfully  deleted";
    }

}
