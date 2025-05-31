package com.jonas.supabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonas.supabase.dto.UserRequest;
import com.jonas.supabase.model.User;
import com.jonas.supabase.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User update(Long id, UserRequest userRequest){
        User user = findById(id);
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
    

}
