package com.dreamix.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "actors")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Actor extends BaseModel {
    @NotNull(message = "First name can't be null.")
    @Size(max = 50, message = "First name can't be more than 50 characters.")
    private String firstName;
    @NotNull(message = "Last name can't be null.")
    @Size(max = 50, message = "Last name can't be more than 50 characters.")
    private String lastName;
    @NotNull(message = "Age can't be null.")
    @Min(value = 0, message = "Age can't be less than 0!")
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
