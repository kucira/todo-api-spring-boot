package com.todo.api.todoapi.services;

import com.todo.api.todoapi.models.TodoDto;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private ArrayList<TodoDto> todos = new ArrayList<>();

  public TodoService() {
    TodoDto todoDto1 = new TodoDto(1, "test 1", "test 1 description todo");
    TodoDto todoDto2 = new TodoDto(2, "test 2", "test 2 description todo");
    TodoDto todoDto3 = new TodoDto(3, "test 3", "test 3 description todo");
    todos.addAll(Arrays.asList(todoDto1, todoDto2, todoDto3));
  }

  public ArrayList<TodoDto> getTodos() {
    return this.todos;
  }

  public TodoDto createTodo(TodoDto todo) {
    todos.add(todo);
    return todo;
  }

  public TodoDto deleteTodo(Integer indexArr) {
    TodoDto todo = todos.get(indexArr);
    return todo;
  }

  public TodoDto updateTodo(TodoDto todo) {
    int index = todos.indexOf(todo);
    todos.set(index, todo);
    return todo;
  }
}