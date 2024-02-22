package com.todo_ec.model.repository;


import com.todo_ec.model.entity.TodoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoUsuarioRepository extends CrudRepository<TodoUsuario, Integer> {

    Optional<TodoUsuario> findByUsuario(String usuario);

    Optional<TodoUsuario> findByCorreo(String correo);

    Boolean existsByUsuario(String usuario);
    Boolean existsByCorreo(String correo);
}
