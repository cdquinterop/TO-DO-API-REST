package com.todo_ec.controller;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //Para indicar que es un controlador
@RequestMapping("/api/v1") //Para indicar que este controlador va ser usado como recurso
public class TodoEstadoController {

    @Autowired
    private TodoEstadoService todoEstadoService;

    //Create User
    @PostMapping("/estado")
    public ResponseEntity<?> create(@RequestBody TodoEstadoDTO todoEstadoDTO) {
        TodoEstado savedStatus = todoEstadoService.save(todoEstadoDTO);
        return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
    }
    //Show All User
    @GetMapping("/estados")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<TodoEstado> showAllUser(){
        return todoEstadoService.findAll();
    }
    @GetMapping("/estado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  TodoEstado showById(@PathVariable Integer id) {
        return todoEstadoService.findById(id);
    }

    //Update User
    @PutMapping("/estado")
    public ResponseEntity<?> update(@RequestBody TodoEstadoDTO todoEstadoDTO) {
        TodoEstado updateStatus = todoEstadoService.update(todoEstadoDTO);
        // Usamos HttpStatus.CREATED para indicar que la operación fue una actualización exitosa.
        return new ResponseEntity<>(updateStatus, HttpStatus.CREATED);
    }


    //Delete User ById
    @DeleteMapping("/estado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        todoEstadoService.deleteById(id);
    }

}
