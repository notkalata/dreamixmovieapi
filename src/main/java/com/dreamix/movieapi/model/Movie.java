package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseModel {
    @NotNull(message = "Title can't be null.")
    @Size(max = 50, message = "Title can't be more than 50 characters.")
    private String title;
    @Size(max = 500, message = "Description can't be more than 500 characters.")
    private String description;
    @NotNull(message = "Runtime can't be null.")
    @Min(value = 0, message = "Runtime can't be less than 0")
    private Integer runtime;
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
    public void updateFrom(Movie movie){
        if(this.getTitle() == null){
            this.setTitle(movie.getTitle());
        }
        if(this.getDescription() == null){
            this.setDescription(movie.getDescription());
        }
        if(this.getRuntime() == null){
            this.setRuntime(movie.getRuntime());
        }
        if(this.getReleaseDate() == null){
            this.setReleaseDate(movie.getReleaseDate());
        }
        if(this.getReviews() == null){
            this.setReviews(movie.getReviews());
        }
        if(this.getActors() == null){
            this.setActors(movie.getActors());
        }
        if(this.getGenres() == null){
            this.setGenres(movie.getGenres());
        }
    }
}
