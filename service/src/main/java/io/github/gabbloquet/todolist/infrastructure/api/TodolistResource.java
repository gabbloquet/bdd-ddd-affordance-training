package io.github.gabbloquet.todolist.infrastructure.api;

import io.github.gabbloquet.todolist.domain.InPort.TodolistService;
import io.github.gabbloquet.todolist.domain.model.Task;
import io.github.gabbloquet.todolist.domain.model.Todolist;
import io.github.gabbloquet.todolist.infrastructure.api.dto.todolist.TodolistResponseMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
public class TodolistResource {
    @NonNull
    private final TodolistService todolistService;

    @NonNull
    private final TodolistResponseMapper todolistResponseMapper;

    @GetMapping()
    public EntityModel<Todolist> get() {
        Todolist todolist = todolistService.get();
        return todolistResponseMapper.map(todolist);
    }

    @PutMapping("/move")
    public EntityModel<Todolist> move(@RequestBody MoveTaskRequest request) {
        Todolist todolist = todolistService.move(new Task(request.getTask()), request.getPosition());
        return todolistResponseMapper.map(todolist);
    }
}
