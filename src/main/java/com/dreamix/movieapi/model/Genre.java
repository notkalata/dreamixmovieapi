package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends BaseModel {
    @NotNull(message = "Name can't be null.")
    @Size(max = 50, message = "Name can't be more than 50 characters.")
    private String name;
    @Size(max = 200, message = "Description can't be more than 200 characters.")
    private String description;
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;
    @ManyToMany(mappedBy = "favouriteGenres")
    private List<User> users;
    public void updateFrom(Genre genre){
        if(this.name == null){
            this.setName(genre.getName());
        }
        if(this.description == null){
            this.setDescription(genre.getDescription());
        }
    }
}
