package com.varun.properToDo.ToDoStuff.ToDo;

import com.varun.properToDo.ToDo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoService
{
    @Autowired
    private ToDoRepository toDoRepository;

    public void save(ToDoUser toDoUser)
    {
        toDoRepository.save(toDoUser);
    }

    public List<ToDoUser> listodo(String username)
    {
        return toDoRepository.findByUsername(username);
    }

    @Transactional
    public void deleteTodo(String username,String description)
    {
        toDoRepository.deleteByUsernameAndDescription(username,description);
    }

}
