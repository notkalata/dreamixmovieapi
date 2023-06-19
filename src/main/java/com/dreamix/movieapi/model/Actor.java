package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "actor")
@Table(name = "actors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor extends BaseModel {
    private String firstName;
    private String lastName;
    private int age;
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;
}
