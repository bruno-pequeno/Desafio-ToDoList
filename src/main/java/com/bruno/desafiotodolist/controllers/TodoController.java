package com.bruno.desafiotodolist.controllers;

import com.bruno.desafiotodolist.models.TodoModel;
import com.bruno.desafiotodolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/new")
    public List<TodoModel> create(@RequestBody TodoModel todoCreate){
        return todoService.create(todoCreate);
    }

    @GetMapping
    public List<TodoModel> list(){
        return todoService.list();
    }

    @PutMapping
    public List<TodoModel> update(@RequestBody TodoModel todoUpdate){
        return todoService.update(todoUpdate);
    }

    @DeleteMapping("{id}")
    public List<TodoModel> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
