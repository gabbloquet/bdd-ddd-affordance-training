package io.github.gabbloquet.todolist.domain.task.infra;

import io.github.gabbloquet.todolist.domain.task.TaskRepository;
import io.github.gabbloquet.todolist.domain.task.model.Task;
import io.github.gabbloquet.todolist.domain.task.model.TaskId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryTaskRepository implements TaskRepository {

    private final ConcurrentMap<TaskId, Task> tasks = new ConcurrentHashMap<>();

    @Override
    public List<Task> get() {
        return tasks.values().stream().toList();
    }

    @Override
    public Optional<Task> get(TaskId taskId) {
        return Optional.ofNullable(tasks.get(taskId));
    }

    @Override
    public void save(Task task) {
        tasks.put(task.taskId, task);
    }
}
