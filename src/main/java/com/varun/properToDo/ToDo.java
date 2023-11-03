package com.varun.properToDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

public class ToDo {
    @SpringBootApplication
    @EntityScan(basePackages = "com.varun.properToDo.ToDoStuff")
    public static class ProperToDoApplication {

        public static void main(String[] args) {
            SpringApplication.run(ProperToDoApplication.class, args);
        }

    }
}
