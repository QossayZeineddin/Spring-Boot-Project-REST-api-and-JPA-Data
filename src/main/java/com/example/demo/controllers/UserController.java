package com.example.demo.controllers;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @DeleteMapping("delete/user")
    public String DeleteUser(Model model, @RequestBody String id) {
        userService.DeleteUserById(Integer.parseInt(id));
        return "done";
    }

    @PostMapping("/insert/new-user")
    public Users done(Model model, @RequestBody Users users) {
        System.out.println("heeerererererere");

        System.out.println("New New" + users.toString());
        return userService.addNewUser(users);


    }
    @GetMapping("/getAll")
    public List<Users> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/update/user")
    public Users update(Model model, @RequestBody Users users) {
        System.out.print("\n\nUpdate user to: " + users.toString() + "\n");
        Users u1 = userService.findById(users.getId());
        Users u11 = userService.updateUser(users.getId(), users.getName(), users.getEmail(), users.getPhonenum(),
                users.getGender(), users.getUserDateOfBrith(), users.getUserType(), users.getPassword());
        return  u11;
    }



}
