package com.bruno.desafiotodolist.services;

import com.bruno.desafiotodolist.models.TodoModel;
import com.bruno.desafiotodolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoModel> create(TodoModel todoSave) {
        todoRepository.save(todoSave);

        return list();
    }

    public List<TodoModel> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<TodoModel> update(TodoModel todoUpdate) {
        todoRepository.save(todoUpdate);
        return list();
    }

    public List<TodoModel> delete(Long id) {
        todoRepository.deleteById(id);

        return list();
    }
}
