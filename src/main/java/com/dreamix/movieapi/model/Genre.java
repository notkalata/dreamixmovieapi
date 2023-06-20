package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name =  "genre")
@Table(name = "genres")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends BaseModel {
    private String name;
    private String description;
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;
    @ManyToMany(mappedBy = "favouriteGenres")
    private Set<User> users;
    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
