package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoUsuarioImpl implements TodoUsuarioService {
    @Autowired
    private TodoUsuarioRepository todoUsuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public TodoUsuario save(TodoUsuarioDTO todoUsuarioDTO) {

        TodoUsuario todoUsuario = new TodoUsuario();
        BeanUtils.copyProperties(todoUsuarioDTO,todoUsuario);

        String cifrado = passwordEncoder.encode(todoUsuario.getContrasena());
        todoUsuario.setContrasena(cifrado);

        return todoUsuarioRepository.save(todoUsuario);
    }

    @Override
    @Transactional
    public TodoUsuario update(TodoUsuarioDTO todoUsuarioDTO) {
        if (todoUsuarioDTO.getIdUsuario() == null) {
            throw new IllegalArgumentException("El ID del usuario es necesario para la actualización");
        }
        TodoUsuario existingTodoUsuario = todoUsuarioRepository.findById(todoUsuarioDTO.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + todoUsuarioDTO.getIdUsuario()));

        // Actualiza solo si el campo 'usuario' no es nulo
        if (todoUsuarioDTO.getUsuario() != null) {
            existingTodoUsuario.setUsuario(todoUsuarioDTO.getUsuario());
        }
        // Actualiza solo si el campo 'correo' no es nulo
        if (todoUsuarioDTO.getCorreo() != null) {
            existingTodoUsuario.setCorreo(todoUsuarioDTO.getCorreo());
        }
        // Actualiza la contraseña solo si no es nula ni vacía
        if (todoUsuarioDTO.getContrasena() != null && !todoUsuarioDTO.getContrasena().isEmpty()) {
            existingTodoUsuario.setContrasena(passwordEncoder.encode(todoUsuarioDTO.getContrasena()));
        }


        return todoUsuarioRepository.save(existingTodoUsuario);
    }

    @Transactional(readOnly = true) //Se utiliza para que no se caiga la transacción
    @Override
    public Iterable<TodoUsuario> findAll() {
        return todoUsuarioRepository.findAll();
    }


    @Override
    public TodoUsuario findById(Integer id) {
        return todoUsuarioRepository.findById(id).orElse(null); //me retorna null cuando no se encuentra el dato
    }


    @Transactional
    @Override
    public void deleteById(Integer id) {
        todoUsuarioRepository.deleteById(id);
    }
}
