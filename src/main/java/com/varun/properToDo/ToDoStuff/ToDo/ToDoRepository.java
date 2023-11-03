package com.varun.properToDo.ToDoStuff.ToDo;

import com.varun.properToDo.ToDoStuff.ToDo.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoUser,Long>
{
    public List<ToDoUser> findByUsername(String username);

    public void deleteByUsernameAndDescription(String username,String description);
}
