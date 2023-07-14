package com.dreamix.movieapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewDTO {
    private Long id;
    private Double rating;
    private String description;
    private Long movieId;
    private UserLiteDTO user;
    private String writtenOn;
}
