package io.github.gabbloquet.todolist.domain;

import io.cucumber.spring.ScenarioScope;
import io.github.gabbloquet.todolist.MockRegistry;
import io.github.gabbloquet.todolist.domain.InPort.TodolistService;
import io.github.gabbloquet.todolist.domain.InPort.TodolistServiceImpl;
import io.github.gabbloquet.todolist.domain.features.DeprioritizeTaskUseCase;
import io.github.gabbloquet.todolist.domain.features.PriorizeTaskUseCase;
import io.github.gabbloquet.todolist.domain.repositories.TaskRepository;
import io.github.gabbloquet.todolist.domain.repositories.TodolistRepository;
import io.github.gabbloquet.todolist.domain.features.UpdateTaskUseCase;
import io.github.gabbloquet.todolist.domain.model.Todolist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.RequestScope;

public class TodolistSpringTestConfig {

    @Bean
    @ScenarioScope
    public Todolist todolist() {
        return new Todolist();
    }

    @Bean
    public MockRegistry mockRegistry() {
        return new MockRegistry();
    }

    @Bean
    @RequestScope
    public TodolistRepository todolistRepository(MockRegistry registry) {
        return registry.mock(TodolistRepository.class);
    }

    @Bean
    @RequestScope
    public TaskRepository taskRepository(MockRegistry registry) {
        return registry.mock(TaskRepository.class);
    }

    @Bean
    @Primary
    public TodolistService todolistService(
            TaskRepository taskRepository,
            TodolistRepository todolistRepository,
            Todolist todolist
    ) {
        return new TodolistServiceImpl(taskRepository, todolistRepository, todolist);
    }

    @Bean
    public UpdateTaskUseCase updateTaskUseCase(
            TaskRepository taskRepository,
            TodolistRepository todolistRepository,
            Todolist todolist
    ) {
        return new UpdateTaskUseCase(taskRepository, todolistRepository, todolist);
    }

    @Bean
    public PriorizeTaskUseCase priorizeTaskUseCase(
            Todolist todolist,
            TodolistRepository todolistRepository
            ) {
        return new PriorizeTaskUseCase(todolist, todolistRepository);
    }

    @Bean
    public DeprioritizeTaskUseCase deprioritizeTaskUseCase(
            Todolist todolist,
            TodolistRepository todolistRepository
    ) {
        return new DeprioritizeTaskUseCase(todolist, todolistRepository);
    }
}
