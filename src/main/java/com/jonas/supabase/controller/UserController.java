package com.jonas.supabase.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonas.supabase.dto.UserRequest;
import com.jonas.supabase.dto.UserResponse;
import com.jonas.supabase.model.User;
import com.jonas.supabase.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest){
        User user = userService.save(userRequest);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        User user = userService.findById(id);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @GetMapping
    public List<UserResponse> findAll(){
        List<User> users = userService.findAll();
        return users.stream().map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail())).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        User user = userService.update(id, userRequest);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    
}
