package com.picpaysimplificado.controllers;

import com.picpaysimplificado.domain.user.Users;
import com.picpaysimplificado.dto.UserDto;
import com.picpaysimplificado.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    private ResponseEntity<Users> createUser (@RequestBody UserDto user){
        Users newuser = userService.createUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);

    }

    @GetMapping
    private ResponseEntity<List<Users>> getAllUsers(){
       List<Users> Users = this.userService.getAllUsers();
       return new ResponseEntity<>(Users, HttpStatus.OK);
    }
}
