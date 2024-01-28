package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoUsuarioDTO;
import com.todo_ec.model.repository.TodoUsuarioRepository;
import com.todo_ec.model.entity.TodoUsuario;
import com.todo_ec.service.TodoUsuarioService;
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
