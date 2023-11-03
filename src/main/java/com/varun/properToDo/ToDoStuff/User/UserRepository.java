package com.varun.properToDo.ToDoStuff.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserNameAndPassword(String username, String password);
}
