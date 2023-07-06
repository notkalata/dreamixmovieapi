package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.model.User;
import com.dreamix.movieapi.service.UserService;
import org.apache.commons.lang3.StringUtils;
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
        map.setFullName(StringUtils.joinWith(" ", user.getFirstName(), user.getLastName()));
        return map;
    }
    public User convertDtoToEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User map = modelMapper.map(userDTO, User.class);
        User existingUser = userService.getUser(userDTO.getId());
        if(userDTO.getFullName() == null){
            map.setFirstName(existingUser.getFirstName());
            map.setLastName(existingUser.getLastName());
        }
        if(userDTO.getUsername() == null){
            map.setUsername(existingUser.getUsername());
        }
        if(userDTO.getPassword() == null){
            map.setPassword(existingUser.getPassword());
        }
        if(userDTO.getEmail() == null){
            map.setEmail(existingUser.getEmail());
        }
        return map;
    }
}
