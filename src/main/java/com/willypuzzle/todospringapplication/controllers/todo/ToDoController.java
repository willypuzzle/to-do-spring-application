package com.willypuzzle.todospringapplication.controllers.todo;

import com.willypuzzle.todospringapplication.dto.todo.TodoDto;
import com.willypuzzle.todospringapplication.services.todo.contracts.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ToDoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("todo")
    public ResponseEntity<TodoDto> createTodo(@Valid @RequestBody TodoDto todoDto){
        return new ResponseEntity<TodoDto>(todoService.saveTodo(todoDto), HttpStatus.CREATED);
    }

    @DeleteMapping("todo")
    public ResponseEntity<Object> deleteTodo(Long todoId){
        todoService.deleteTodo(todoId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @GetMapping("todo")
    public List<TodoDto> indexTodo(){
        return todoService.getAllTodos();
    }
}
