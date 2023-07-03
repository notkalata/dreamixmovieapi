package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String username;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews;
    @ManyToMany
    @JoinTable(
            name = "favourite_genres",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> favouriteGenres;
    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
