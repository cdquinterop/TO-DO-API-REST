package com.todo_ec.controller;

import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //Para indicar que es un controlador
@RequestMapping("/api/v1") //Para indicar que este controlador va ser usado como recurso
public class TodoUsuarioController {
    @Autowired
    private TodoUsuarioService  usuarioService ;

    //Create User
    @PostMapping("/usuario")
    public ResponseEntity<?> create(@RequestBody TodoUsuarioDTO usuarioDTO) {
        TodoUsuario savedUser = usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Show All User
    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<TodoUsuario> showAllUser(){
        return usuarioService.findAll();
    }
    //Update User
    @PutMapping("/usuario")
    public ResponseEntity<?> update(@RequestBody TodoUsuarioDTO usuarioDTO) {
        TodoUsuario updatedUser = usuarioService.update(usuarioDTO);
        // Usamos HttpStatus.CREATED para indicar que la operación fue una actualización exitosa.
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    //Delete User ById
    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        usuarioService.deleteById(id);
    }

}
