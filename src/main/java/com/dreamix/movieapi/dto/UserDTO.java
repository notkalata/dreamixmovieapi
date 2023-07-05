package com.dreamix.movieapi.dto;

import com.dreamix.movieapi.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String fullName;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    public UserDTO(User user){
        id = user.getId();
        password = user.getPassword();
        fullName = user.getFirstName() + " " + user.getLastName();
        username = user.getUsername();
        email = user.getEmail();
    }
}
