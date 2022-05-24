package com.willypuzzle.todospringapplication.dto.todo;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Data
public class TodoDto {
    private Long id;
    private String what;
    private Date when;
    private String where;

    public void setWhen(String when) throws ParseException {
        this.when = DateFormat.getDateTimeInstance().parse(when);
    }
}
