package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoUsuarioImpl implements TodoUsuarioService {
    @Autowired
    private TodoUsuarioRepository todoUsuarioRepository;

    @Transactional
    @Override
    public TodoUsuario save(TodoUsuarioDTO todoUsuarioDTO) {

        TodoUsuario todoUsuario = new TodoUsuario();
        BeanUtils.copyProperties(todoUsuarioDTO,todoUsuario);

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

        BeanUtils.copyProperties(todoUsuarioDTO, existingTodoUsuario, "idUsuario");
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
