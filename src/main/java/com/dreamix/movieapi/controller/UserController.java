package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.UserConverter;
import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.dto.UserLiteDTO;
import com.dreamix.movieapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;
    // Този метод връща цялата информация за потребител, като зарежда всички списъци.
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        if(userService.getUser(id) == null){
            return null;
        }
        return userConverter.convertEntityToDto(userService.getUser(id));
    }
    // Този метод връща само базова информация за потребител, за да не зарежда всички списъци.
    @GetMapping("/all")
    public List<UserLiteDTO> getAllUsers(){
        return userService.getAllUsers().stream().map(user -> userConverter.convertEntityToLiteDto(user)).collect(Collectors.toList());
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
    @GetMapping("/filter")
    public List<UserLiteDTO> filterUsers(@RequestBody HashMap<String, Object> filter){
        return userService.filterUsers(filter).stream().map(user -> userConverter.convertEntityToLiteDto(user)).collect(Collectors.toList());
    }
}
