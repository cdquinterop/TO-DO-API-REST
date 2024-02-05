package com.todo_ec.model.repository;

import com.todo_ec.model.entity.TodoTarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTareaRepository extends CrudRepository <TodoTarea, Integer> {
}
