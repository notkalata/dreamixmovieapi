package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.model.User;
import com.dreamix.movieapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        return new UserDTO(userService.getUser(id));
    }
    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers().stream().map(UserDTO::new).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public UserDTO addRecord(@RequestBody User user){
        return new UserDTO(userService.addRecord(user));
    }
    @PutMapping("/update")
    public UserDTO updateRecord(@RequestBody User user){
        return new UserDTO(userService.updateRecord(user));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        userService.deleteRecord(id);
    }
}
