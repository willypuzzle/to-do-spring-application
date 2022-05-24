package com.willypuzzle.todospringapplication.dto.todo;

import lombok.Data;

import java.util.Date;

@Data
public class TodoDto {
    private Long id;
    private String what;
    private Date when;
    private String where;
}
