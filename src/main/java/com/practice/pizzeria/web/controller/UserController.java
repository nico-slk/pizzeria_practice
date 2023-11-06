package com.practice.pizzeria.web.controller;

import com.practice.pizzeria.persistance.entity.UserEntity;
import com.practice.pizzeria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserEntity> getUserByName(@PathVariable String userName) {
        return ResponseEntity.ok(this.userService.getUser(userName));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
