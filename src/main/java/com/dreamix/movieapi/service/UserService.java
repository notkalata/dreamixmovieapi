package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.User;
import com.dreamix.movieapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(long id){
        return userRepository.findById(id);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User addRecord(User user){
        return userRepository.create(user);
    }
    public User updateRecord(User user){
        return userRepository.update(user);
    }
    public void deleteRecord(long id){
        userRepository.delete(id);
    }
}
