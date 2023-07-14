package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseModel {
    private Double rating;
    private String description;
    private LocalDateTime writtenOn;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public void updateFrom(Review review){
        if(this.rating == null){
            this.setRating(review.getRating());
        }
        if(this.description == null){
            this.setDescription(review.getDescription());
        }
        if(this.writtenOn == null){
            this.setWrittenOn(review.getWrittenOn());
        }
        if(this.user == null){
            this.setUser(review.getUser());
        }
    }
}
