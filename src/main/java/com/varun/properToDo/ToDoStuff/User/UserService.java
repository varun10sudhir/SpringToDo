package com.varun.properToDo.ToDoStuff.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void save(User user)
    {
        userRepository.save(user);
    }

    public User loginUser(String username,String password)
    {
        return userRepository.findByUserNameAndPassword(username,password);
    }
}
