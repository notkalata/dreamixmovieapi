package com.dreamix.movieapi.service;

import com.dreamix.movieapi.dto.Filter;
import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Movie getMovie(long id){
        return movieRepository.findById(id);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie addRecord(Movie movie){
        return movieRepository.create(movie);
    }
    public Movie updateRecord(Movie movie){
        return movieRepository.update(movie);
    }
    public void deleteRecord(long id){
        movieRepository.delete(id);
    }
    public List<Movie> filterMovies(List<Filter> filters){
        return movieRepository.filter(filters);
    }
}
