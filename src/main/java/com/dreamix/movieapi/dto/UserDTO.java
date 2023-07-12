package com.dreamix.movieapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private List<GenreDTO> favouriteGenres;
}
