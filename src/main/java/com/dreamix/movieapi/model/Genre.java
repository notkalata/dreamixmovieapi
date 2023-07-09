package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends BaseModel {
    private String name;
    private String description;
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;
    @ManyToMany(mappedBy = "favouriteGenres")
    private List<User> users;
}
