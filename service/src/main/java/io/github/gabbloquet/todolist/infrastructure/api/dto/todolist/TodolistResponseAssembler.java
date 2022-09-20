package io.github.gabbloquet.todolist.infrastructure.api.dto.todolist;

import io.github.gabbloquet.todolist.infrastructure.api.TodolistResource;
import io.github.gabbloquet.todolist.infrastructure.api.dto.tasks.TaskDto;
import io.github.gabbloquet.todolist.infrastructure.api.dto.tasks.TasksResponseAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
@RequiredArgsConstructor
public class TodolistResponseAssembler {

    private final TasksResponseAssembler tasksResponseAssembler;

    private final TodolistResource todolistResource = methodOn(TodolistResource.class);

    public EntityModel<TodolistResponse> map(TodolistDto todolist) {
        var todolistResponse = new TodolistResponse(getTasksAffordances(todolist));

        return EntityModel.of(
                todolistResponse,
                getSelfLink(),
                getMoveTaskAffordance());
    }

    private List<EntityModel<TaskDto>> getTasksAffordances(TodolistDto todolist) {
        return todolist.tasks().stream()
                .map((tasksResponseAssembler::map))
                .toList();
    }

    private Link getMoveTaskAffordance() {
        MoveTaskRequest taskRequest = new MoveTaskRequest(0, 0);
        return linkTo(todolistResource.move(taskRequest)).withRel("moveTask").withTitle("Move a task");
    }

    private Link getSelfLink() {
        return linkTo(todolistResource.get()).withSelfRel().withTitle("Get todolist");
    }
}