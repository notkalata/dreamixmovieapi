package com.dreamix.movieapi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    @NotNull(message = "Username can't be null.")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters.")
    private String username;
    @NotBlank(message = "Password can't be empty!")
    private String password;
    @Email(message = "Email should be valid.")
    private String email;
    @NotNull(message = "First name can't be null.")
    @Size(max = 50, message = "First name can't be more than 50 characters.")
    private String firstName;
    @NotNull(message = "Last name can't be null.")
    @Size(max = 50, message = "Last name can't be more than 50 characters.")
    private String lastName;
    @OneToMany(mappedBy = "user")
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
