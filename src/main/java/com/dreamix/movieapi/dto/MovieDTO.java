package com.dreamix.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private long id;
    private String title;
    private String description;
    private int runtime;
    private List<ActorDTO> actors;
}
