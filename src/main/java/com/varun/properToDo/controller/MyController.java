package com.varun.properToDo.controller;

import com.varun.properToDo.ToDoStuff.ToDo.ToDoService;
import com.varun.properToDo.ToDoStuff.ToDo.ToDoUser;
import com.varun.properToDo.ToDoStuff.User.User;
import com.varun.properToDo.ToDoStuff.User.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @Autowired
    ToDoService toDoService;

    @GetMapping("/")
    public String homePage() {
        return "HomePage";
    }

    @GetMapping("/todo")
    public String todos(HttpSession session, Model model) {
        String username = (String) session.getAttribute("name");
        if (session.getAttribute("name") == null) {
            return "redirect:login";
        }
        model.addAttribute("todos", toDoService.listodo(username));
        return "ToDos";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println(username + password);
        if (userService.loginUser(username, password) == null) {
            return "redirect:login";
        }

        session.setAttribute("name", username);
        return "redirect:todo";
    }


    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String signUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = new User(username, password);
        System.out.println(user.getUserName());
        userService.save(user);
        session.setAttribute("name", user.getUserName());
        return "redirect:todo";
    }

    @RequestMapping(value = "/newtodo", method = RequestMethod.POST)
    public String addingnewTodo(@RequestParam String description, @RequestParam String targetedDate, HttpSession session) {
        String username = (String) session.getAttribute("name");
        ToDoUser toDoUser = new ToDoUser(username, description, targetedDate, "Progress");
        toDoService.save(toDoUser);
        return "redirect:todo";
    }

    @GetMapping("/signup")
    public String signup() {
        return "SignUp";
    }

    @GetMapping("/newtodo")
    public String newtod(HttpSession session) {
        String username = (String) session.getAttribute("name");
        if (session.getAttribute("name") == null) {
            return "redirect:login";
        }
        return "NewToDo";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.removeAttribute("name");
        return "redirect:";
    }


    @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam String description,HttpSession session)
    {
        String username = (String)session.getAttribute("name");
        toDoService.deleteTodo(username,description);
        return "redirect:todo";
    }
}
