package io.github.gabbloquet.todolist.domain.task.modifyTask;

import io.github.gabbloquet.todolist.annotations.DomainCommand;
import io.github.gabbloquet.todolist.domain.task.TaskCommand;
import io.github.gabbloquet.todolist.domain.task.model.TaskId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@DomainCommand
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class ModifyTask extends TaskCommand {

    @NonNull
    public final TaskId taskId;

    @NonNull
    public final String update;

}