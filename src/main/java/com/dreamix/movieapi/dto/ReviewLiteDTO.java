package com.dreamix.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLiteDTO {
    private Long id;
    private Double rating;
    private String description;
}
