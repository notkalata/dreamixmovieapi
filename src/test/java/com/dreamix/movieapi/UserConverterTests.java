package com.dreamix.movieapi;

import com.dreamix.movieapi.converter.UserConverter;
import com.dreamix.movieapi.dto.UserDTO;
import com.dreamix.movieapi.dto.UserLiteDTO;
import com.dreamix.movieapi.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserConverterTests {
    private final UserConverter userConverter = new UserConverter();
    @Test
    public void checkNullEntity(){
        UserDTO userDTO = userConverter.convertEntityToDto(null);
        UserLiteDTO userLiteDTO = userConverter.convertEntityToLiteDto(null);
        assertNull(userDTO);
        assertNull(userLiteDTO);
    }
    @Test
    public void checkNullDTO(){
        User user = userConverter.convertDtoToEntity(null);
        assertNull(user);
    }
    @Test
    public void checkEntityToDtoConvert(){
        User user = new User("notkalata", "kaloyan1", "kaloyan@email.com",
                "Kaloyan", "Georgiev", null, null);
        UserDTO dto = new UserDTO(null, "Kaloyan Georgiev", "notkalata",
                null, "kaloyan@email.com", null);
        UserDTO expectedDto = userConverter.convertEntityToDto(user);
        assertEquals(dto, expectedDto);
    }
    @Test
    public void checkDtoToEntityConvert(){
        UserDTO userDTO = new UserDTO(null, "Kaloyan Georgiev", "notkalata",
                "kaloyan1", "kaloyan@email.com", null);
        User user = new User("notkalata", "kaloyan1", "kaloyan@email.com",
                "Kaloyan", "Georgiev", null, null);
        User expectedUser = userConverter.convertDtoToEntity(userDTO);
        assertEquals(user, expectedUser);
    }
    @Test
    public void checkDtoToEntityConvertWithNoFullName(){
        UserDTO userDTO = new UserDTO(null, null, "notkalata",
                "kaloyan1", "kaloyan@email.com", null);
        User user = new User("notkalata", "kaloyan1", "kaloyan@email.com",
                "First", "Last", null, null);
        User expectedUser = userConverter.convertDtoToEntity(userDTO);
        assertEquals(user, expectedUser);
    }
}
