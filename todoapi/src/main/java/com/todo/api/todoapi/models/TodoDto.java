package com.todo.api.todoapi.models;

public class TodoDto {

  private int id;
  private String title;
  private String description;
  private boolean completed;

  public TodoDto(int id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.completed = false;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
