package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO convertEntityToDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, UserDTO> mapper = modelMapper.createTypeMap(User.class, UserDTO.class);
        mapper.addMappings(mMapper -> mMapper.skip(UserDTO::setPassword));
        return modelMapper.map(user, UserDTO.class);
    }
    public User convertDtoToEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}
