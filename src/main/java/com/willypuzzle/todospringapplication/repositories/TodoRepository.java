package com.willypuzzle.todospringapplication.repositories;

import com.willypuzzle.todospringapplication.models.main.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
