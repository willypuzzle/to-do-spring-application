package com.willypuzzle.todospringapplication.dto.todo;

import com.willypuzzle.todospringapplication.libraries.logging.ApplicationLogger;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TodoDto {
    private Long id;

    @NotEmpty
    private String what;

    @NotEmpty
    @Pattern(regexp = "^\\d{4}\\-\\d{2}\\-\\d{2}T\\d{2}\\:\\d{2}\\:\\d{2}$")
    private String when;

    @NotEmpty
    private String where;

    public void setWhen(String date){
        ApplicationLogger.logger().debug("setWhen: " + date);
        when = date;
    }

    public LocalDateTime getWhen(){
        ApplicationLogger.logger().debug("getWhen: " + when);
        return LocalDateTime.parse(when);
    }

    public void setWhen(Date date){
        this.when = String.valueOf(date);
    }
}
