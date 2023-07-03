package com.dreamix.movieapi.service;

import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Movie getMovie(long id){
        return movieRepository.findById(id);
    }
    public List<MovieDTO> getAllMovies(){
            return movieRepository.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
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
    public MovieDTO entityToDTO(Movie movie){
        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getRuntime());
    }
}
