package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.dto.UserLiteDTO;
import com.dreamix.movieapi.model.User;
import com.dreamix.movieapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private UserService userService;
    public UserDTO convertEntityToDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, UserDTO> typeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
        typeMap.addMappings(mapper -> {
            mapper.skip(UserDTO::setPassword);
        });
        UserDTO map = modelMapper.map(user, UserDTO.class);
        map.setFullName(user.getFirstName() + " " + user.getLastName());
        return map;
    }

    public UserLiteDTO convertEntityToLiteDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        UserLiteDTO map = modelMapper.map(user, UserLiteDTO.class);
        map.setFullName(user.getFirstName() + " " + user.getLastName());
        return map;
    }

    public User convertDtoToEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User map = modelMapper.map(userDTO, User.class);
        if(userDTO.getId() != null){
            User existing = userService.getUser(userDTO.getId());
            map.updateFrom(existing);
        }
        map.setFirstName(userDTO.getFullName().split(" ")[0]);
        map.setLastName(userDTO.getFullName().split(" ")[1]);
        return map;
    }
}
