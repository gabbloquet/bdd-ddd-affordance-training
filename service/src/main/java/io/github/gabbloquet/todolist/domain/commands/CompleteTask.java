package io.github.gabbloquet.todolist.domain.commands;

import io.github.gabbloquet.todolist.application.annotations.DomainCommand;
import io.github.gabbloquet.todolist.domain.model.TaskId;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@DomainCommand
@Builder
@ToString
@Getter
public final class CompleteTask implements TodolistCommand {
    private final TaskId id;
}
