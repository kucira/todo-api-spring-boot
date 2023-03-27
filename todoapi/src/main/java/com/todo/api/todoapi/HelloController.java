package com.todo.api.todoapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/")
    public String sayHello() {
        return "Hello from spring github codespaces";
    }
}
