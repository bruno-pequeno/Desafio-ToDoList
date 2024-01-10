package com.bruno.desafiotodolist.repositories;

import com.bruno.desafiotodolist.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {


}
