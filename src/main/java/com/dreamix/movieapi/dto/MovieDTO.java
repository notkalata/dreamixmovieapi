package com.dreamix.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Integer runtime;
    private List<ActorDTO> actors;
    private List<ReviewDTO> reviews;
    private List<GenreDTO> genres;
}
