package com.dreamix.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLiteDTO {
    private Long id;
    private String fullName;
    private String username;
    private String email;
}
