package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.repository.MovieRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Log4j2
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
            log.info("Save 4 records.");
        }
    }

    @PostConstruct
    public void displayRecords(){
        if(movieRepository.findAll().size() == 0){
            log.info("No movies to be displayed.");
        }
        else{
            for (Movie movie : movieRepository.findAll()){
               log.info(movie.getTitle() + ", " + movie.getDescription() + ", " + movie.getRuntime());
            }
        }
    }
}
