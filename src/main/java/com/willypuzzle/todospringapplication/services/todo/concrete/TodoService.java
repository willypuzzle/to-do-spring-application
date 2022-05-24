package com.willypuzzle.todospringapplication.services.todo.concrete;

import com.willypuzzle.todospringapplication.dto.todo.TodoDto;
import com.willypuzzle.todospringapplication.models.main.Todo;
import com.willypuzzle.todospringapplication.repositories.TodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TodoDto> getAllTodos(){
        return todoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private TodoDto convertEntityToDto(Todo todo)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        TodoDto todoDto = new TodoDto();
        todoDto = modelMapper.map(todo, TodoDto.class);

        return todoDto;
    }
}
