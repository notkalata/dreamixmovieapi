package com.dreamix.movieapi.dto;

import com.dreamix.movieapi.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private long id;
    private String title;
    private String description;
    private int runtime;
    public MovieDTO(Movie movie){
        id = movie.getId();
        title = movie.getTitle();
        description = movie.getDescription();
        runtime = movie.getRuntime();
    }
}
