package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.UserConverter;
import com.dreamix.movieapi.dto.UserDTO;
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
    @Autowired
    private UserConverter userConverter;
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        return userConverter.convertEntityToDto(userService.getUser(id));
    }
    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers().stream().map(user -> userConverter.convertEntityToDto(user)).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public UserDTO addRecord(@RequestBody UserDTO userDTO){
        return userConverter.convertEntityToDto(userService.addRecord(userConverter.convertDtoToEntity(userDTO)));
    }
    @PutMapping("/update")
    public UserDTO updateRecord(@RequestBody UserDTO userDTO){
       return userConverter.convertEntityToDto(userService.updateRecord(userConverter.convertDtoToEntity(userDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        userService.deleteRecord(id);
    }
}
