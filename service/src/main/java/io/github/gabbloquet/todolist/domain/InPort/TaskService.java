package io.github.gabbloquet.todolist.domain.InPort;

import io.github.gabbloquet.todolist.domain.model.Task;

public interface TaskService {
    Task get(int id);

    Task add(String task);

    Task modify(int id, String update);

    void delete(int id);
}