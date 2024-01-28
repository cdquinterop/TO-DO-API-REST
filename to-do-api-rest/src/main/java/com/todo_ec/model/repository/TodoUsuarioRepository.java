package com.todo_ec.model.repository;


import com.todo_ec.model.entity.TodoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUsuarioRepository extends CrudRepository<TodoUsuario, Integer> {
}
