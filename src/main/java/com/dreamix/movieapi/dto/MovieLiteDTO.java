package com.dreamix.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieLiteDTO {
    private Long id;
    private String title;
    private String description;
    private Integer runtime;
}
