package com.todo_ec.service.Impl;

import com.todo_ec.model.DTOs.TodoEstadoDTO;
import com.todo_ec.model.entity.TodoEstado;
import com.todo_ec.model.repository.TodoEstadoRepository;
import com.todo_ec.service.TodoEstadoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoEstadoImpl implements TodoEstadoService {

    @Autowired
    private TodoEstadoRepository todoEstadoRepository;
    @Transactional
    @Override
    public TodoEstado save(TodoEstadoDTO todoEstadoDTO) {
        TodoEstado todoEstado = new TodoEstado();
        BeanUtils.copyProperties(todoEstadoDTO,todoEstado);

        return todoEstadoRepository.save(todoEstado);
    }

    @Override
    @Transactional
    public TodoEstado update(TodoEstadoDTO todoEstadoDTO) {
        if (todoEstadoDTO.getIdEstado() == null) {
            throw new IllegalArgumentException("El ID del estado es necesario para la actualización");
        }
        TodoEstado existingTodoEstado = todoEstadoRepository.findById(todoEstadoDTO.getIdEstado())
                .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado con ID: " + todoEstadoDTO.getIdEstado()));

        BeanUtils.copyProperties(todoEstadoDTO, existingTodoEstado, "idEstado");
        return todoEstadoRepository.save(existingTodoEstado);
    }


    @Transactional(readOnly = true) //Se utiliza para que no se caiga la transacción
    @Override
    public Iterable<TodoEstado> findAll() {
        return todoEstadoRepository.findAll();
    }

    @Transactional(readOnly = true) //Se utiliza para que no se caiga la transacción
    @Override
    public TodoEstado findById(Integer id) {
        return todoEstadoRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
           todoEstadoRepository.deleteById(id);
    }
}
