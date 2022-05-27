package com.willypuzzle.todospringapplication.dto.todo;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

@Data
public class TodoDto {
    private Long id;

    @NotEmpty
    private String what;

    @NotEmpty
    private String when;

    @NotEmpty
    private String where;

    public Date getWhen(){
        try{
            return DateFormat.getDateTimeInstance().parse(when);
        }catch (ParseException ex){
            return Date.from(Instant.now());
        }
    }
}
