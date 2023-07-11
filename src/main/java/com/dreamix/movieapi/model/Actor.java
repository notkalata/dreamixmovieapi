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
@Table(name = "actors")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Actor extends BaseModel {
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
    public void updateFrom(Actor actor){
        if(this.firstName == null){
            this.setFirstName(actor.getFirstName());
        }
        if(this.lastName == null){
            this.setLastName(actor.getLastName());
        }
        if(this.age == null){
            this.setAge(actor.getAge());
        }
    }
}
