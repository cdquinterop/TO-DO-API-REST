package com.todo_ec.model.repository;

import com.todo_ec.model.entity.TodoEstado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoEstadoRepository extends CrudRepository<TodoEstado, Integer> {
}
