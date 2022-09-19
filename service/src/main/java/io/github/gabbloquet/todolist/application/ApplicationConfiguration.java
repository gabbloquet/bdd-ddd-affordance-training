package io.github.gabbloquet.todolist.application;

import io.github.gabbloquet.todolist.domain.InPort.TaskService;
import io.github.gabbloquet.todolist.domain.InPort.TaskServiceImpl;
import io.github.gabbloquet.todolist.domain.InPort.TodolistService;
import io.github.gabbloquet.todolist.domain.InPort.TodolistServiceImpl;
import io.github.gabbloquet.todolist.domain.OutPort.TaskRepository;
import io.github.gabbloquet.todolist.domain.OutPort.TodolistRepository;
import io.github.gabbloquet.todolist.infrastructure.spi.InMemoryTaskRepository;
import io.github.gabbloquet.todolist.infrastructure.spi.InMemoryTodolistRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TodolistRepository getTodolistRepository() {
        return new InMemoryTodolistRepository();
    }

    @Bean
    public TaskRepository getTaskRepository() {
        return new InMemoryTaskRepository();
    }

    @Bean
    TodolistService todolistService(TodolistRepository todolistRepository) {
        return new TodolistServiceImpl(todolistRepository);
    }

    @Bean
    TaskService taskService(TaskRepository taskRepository, TodolistRepository todolistRepository) {
        return new TaskServiceImpl(taskRepository, todolistRepository);
    }
}