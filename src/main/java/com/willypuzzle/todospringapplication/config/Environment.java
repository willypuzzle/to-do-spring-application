package com.willypuzzle.todospringapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Objects;

public class Environment {

    private org.springframework.core.env.Environment env;

    public Environment(){
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            env = context.getEnvironment();
        }
    }

    public static boolean isProduction(){
        Environment instance = new Environment();
        ArrayList<String> deltas = new ArrayList<>();
        deltas.add("prod");
        deltas.add("production");
        return deltas.stream().reduce("not-found", (String sum, String delta)
                -> {
                if(sum.equals("found")){
                    return sum;
                }
                return Objects.requireNonNull(instance.env.getProperty("spring.application.environment")).equalsIgnoreCase(delta) ? "found" : "not-found";
            }) == "found";
    }
}
