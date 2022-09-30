package io.github.gabbloquet.todolist.domain.features;

import io.github.gabbloquet.todolist.application.annotations.DomainService;
import io.github.gabbloquet.todolist.domain.features.commands.CompleteTask;
import io.github.gabbloquet.todolist.domain.features.events.TaskCompleted;
import io.github.gabbloquet.todolist.domain.models.Task;
import io.github.gabbloquet.todolist.domain.models.TodolistCommandReceiver;
import io.github.gabbloquet.todolist.domain.models.TodolistEventBus;
import io.github.gabbloquet.todolist.domain.repositories.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.function.Supplier;

@DomainService
@RequiredArgsConstructor
public class CompleteTaskUseCase implements TodolistCommandReceiver<CompleteTask> {

    @NonNull
    private final Supplier<Task> taskSupplier;

    @NonNull
    private final TodolistEventBus todolistEventBus;

    @Override
    @EventListener
    public void execute(CompleteTask command) {
        Task task = taskSupplier.get();
        TaskCompleted taskCompleted = task.complete();

        todolistEventBus.publish(taskCompleted);
    }
}
