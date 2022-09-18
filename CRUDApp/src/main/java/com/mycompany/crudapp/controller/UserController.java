package com.mycompany.crudapp.controller;

import com.mycompany.crudapp.model.User;
import com.mycompany.crudapp.service.UserNotFoundException;
import com.mycompany.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> users=userService.listAll();
        model.addAttribute("listUsers",users);
        return "users";
    }
       @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes ra){
        userService.save(user);
        ra.addFlashAttribute("message","The User has been saved successfully.");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try {
            User user=userService.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit User (ID: "+id+")");
            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/users";
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try {
            userService.delete(id);
            ra.addFlashAttribute("message","User ID"+id+"has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/users";
    }

}
