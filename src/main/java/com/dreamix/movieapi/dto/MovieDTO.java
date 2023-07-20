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
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Integer runtime;
    private String releaseDate;
    private Double rating;
    private Integer totalReviews;
    private List<ActorDTO> actors;
    private List<ReviewLiteDTO> reviews;
    private List<GenreDTO> genres;
}
