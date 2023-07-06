package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.model.User;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
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
        map.setFirstName(userDTO.getFullName().split(" ")[0]);
        map.setLastName(userDTO.getFullName().split(" ")[1]);
        return map;
    }
}
