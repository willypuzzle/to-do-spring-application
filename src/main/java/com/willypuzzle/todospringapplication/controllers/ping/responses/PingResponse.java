package com.willypuzzle.todospringapplication.controllers.ping.responses;

import java.time.Instant;
import java.util.Date;

public class PingResponse {
    private Date time;
    private String message;

    public PingResponse()
    {
        this.setTime(Date.from(Instant.now()));
        this.setMessage("pong");
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
