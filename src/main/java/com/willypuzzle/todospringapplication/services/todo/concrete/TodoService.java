package com.willypuzzle.todospringapplication.services.todo.concrete;

import com.willypuzzle.todospringapplication.dto.todo.TodoDto;
import com.willypuzzle.todospringapplication.models.main.Todo;
import com.willypuzzle.todospringapplication.repositories.TodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService implements com.willypuzzle.todospringapplication.services.todo.contracts.TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TodoDto> getAllTodos(){
        return todoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto saveTodo(TodoDto todoDto) {
        Todo todo = this.convertDtoToEntity(todoDto);
        todo = todoRepository.save(todo);
        return convertEntityToDto(todo);
    }

    @Override
    public boolean deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
        return true;
    }

    @Override
    public TodoDto getTodoById(Long todoId) {
        return convertEntityToDto(todoRepository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo not found")));
    }

    private Todo convertDtoToEntity(TodoDto todoDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(todoDto, Todo.class);
    }

    private TodoDto convertEntityToDto(Todo todo)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(todo, TodoDto.class);
    }
}
