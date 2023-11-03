package com.varun.properToDo.ToDoStuff.ToDo;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class ToDoUser
{

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long todo_id;

    private String username;
    private String description;

    private String targetDate;

    private String status;

    public ToDoUser() {
    }

    public ToDoUser(String username, String description, String targetDate, String status) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Long getId() {
        return todo_id;
    }

    public void setId(Long id) {
        this.todo_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoUser{" +
                "todo_id=" + todo_id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
