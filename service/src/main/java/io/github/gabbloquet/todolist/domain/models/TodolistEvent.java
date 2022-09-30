package io.github.gabbloquet.todolist.domain.models;

import io.github.gabbloquet.todolist.application.annotations.DomainEvent;
import io.github.gabbloquet.todolist.domain.features.events.*;

@DomainEvent
public interface TodolistEvent {

    <T> T accept(Visitor<T> visitor);

    interface Visitor<T> {

        T apply(TaskPrioritized event);

        T apply(TaskDeprioritized event);

        T apply(TodolistCreated event);
    }

}

