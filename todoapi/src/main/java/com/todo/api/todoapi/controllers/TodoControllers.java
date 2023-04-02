package com.todo.api.todoapi.controllers;

import com.todo.api.todoapi.models.TodoDto;
import com.todo.api.todoapi.services.TodoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/todos")
public class TodoControllers {

  @Autowired
  private TodoService todoService;

  public TodoControllers(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping(produces = "application/json")
  @ResponseBody
  public ArrayList<TodoDto> getTodos() {
    return this.todoService.getTodos();
  }

  @PostMapping(produces = "application/json")
  public TodoDto createTodo(@RequestBody TodoDto requestTodo) {
    TodoDto todo = new TodoDto(requestTodo.getId(), requestTodo.getTitle(), requestTodo.getDescription());
    return this.todoService.createTodo(todo);
  }

  @DeleteMapping(produces = "application/json")
  public TodoDto deleteTodo( @RequestParam String index) {
    Integer indexInt = Integer.parseInt(index);
    return this.todoService.deleteTodo(indexInt);
  }
}
