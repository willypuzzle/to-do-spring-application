package com.willypuzzle.todospringapplication.services.todo.contracts;

import com.willypuzzle.todospringapplication.dto.todo.TodoDto;

import java.util.List;

public interface TodoService {
    public abstract List<TodoDto> getAllTodos();

    public abstract TodoDto saveTodo(TodoDto todoDto);

    public abstract boolean deleteTodo(Long todoId);

    public abstract TodoDto getTodoById(Long todoId);
}
