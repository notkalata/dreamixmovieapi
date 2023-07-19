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
    private final ModelMapper modelMapper = new ModelMapper();
    private final TypeMap<User, UserDTO> typeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
    public UserDTO convertEntityToDto(User user){
        if(user == null) {
            return null;
        }
        typeMap.addMappings(mapper -> {
            mapper.skip(UserDTO::setPassword);
        });
        UserDTO map = modelMapper.map(user, UserDTO.class);
        map.setFullName(user.getFirstName() + " " + user.getLastName());
        return map;
    }

    public UserLiteDTO convertEntityToLiteDto(User user){
        if(user == null){
            return null;
        }
        UserLiteDTO map = modelMapper.map(user, UserLiteDTO.class);
        map.setFullName(user.getFirstName() + " " + user.getLastName());
        return map;
    }

    public User convertDtoToEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }
        User map = modelMapper.map(userDTO, User.class);
        if(userDTO.getId() != null){
            User existing = userService.getUser(userDTO.getId());
            map.updateFrom(existing);
        }
        if(userDTO.getFullName() != null) {
            map.setFirstName(userDTO.getFullName().split(" ")[0]);
            map.setLastName(userDTO.getFullName().split(" ")[1]);
        }
        return map;
    }
}
