package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    public void saveRecords(){
        if(movieRepository.findAll().size() == 0){
            movieRepository.save(new Movie("Titanic", "Titanic Description", 189));
            movieRepository.save(new Movie("Batman", "Batman Description", 148));
            movieRepository.save(new Movie("Joker", "Joker Description", 176));
            movieRepository.save(new Movie("Jack Reacher", "Jack Reacher Description", 120));
            System.out.println("Save 4 records.");
        }
    }

    @PostConstruct
    public void displayRecords(){
        if(movieRepository.findAll().size() == 0){
            System.out.println("No records to be displayed.");
        }
        else{
            System.out.println("Found records:");
            for (Movie movie : movieRepository.findAll()){
                System.out.println(movie.getTitle() + ", " + movie.getDescription() + ", " + movie.getRuntime());
            }
        }
    }
}
