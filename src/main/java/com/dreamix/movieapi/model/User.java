package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @ManyToMany
    @JoinTable(
            name = "favourite_genres",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> favouriteGenres;
    public void updateFrom(User existing) {
        if(this.username == null){
            this.setUsername(existing.getUsername());
        }
        if(this.password == null){
            this.setPassword(existing.getPassword());
        }
        if(this.email == null){
            this.setEmail(existing.getEmail());
        }
        if(this.firstName == null){
            this.setFirstName(existing.getFirstName());
        }
        if(this.lastName == null){
            this.setLastName(existing.getLastName());
        }
        if(this.getReviews() == null){
            this.setReviews(existing.getReviews());
        }
        if(this.getFavouriteGenres() == null){
            this.setFavouriteGenres(existing.getFavouriteGenres());
        }
    }
}
