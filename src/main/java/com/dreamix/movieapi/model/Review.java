package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "review")
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseModel {
    private double rating;
    private String description;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
