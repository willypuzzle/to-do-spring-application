package com.willypuzzle.todospringapplication.dto.todo;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

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
    private String timezone;

    public Date getWhen(){
        try{
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            s.setTimeZone(getTimezone());
            return DateFormat.getDateTimeInstance().parse(when);
        }catch (ParseException ex){
            return Date.from(Instant.now());
        }
    }

    private TimeZone getTimezone() {
        if(timezone == null){
            timezone = "UTC";
        }

        return TimeZone.getTimeZone(timezone);
    }
}
