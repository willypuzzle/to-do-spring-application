package com.willypuzzle.todospringapplication.controllers.ping;

import com.willypuzzle.todospringapplication.controllers.ping.responses.PingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public PingResponse index() {
        return new PingResponse();
    }
}
