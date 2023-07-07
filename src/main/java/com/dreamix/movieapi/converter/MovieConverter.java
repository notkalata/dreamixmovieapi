package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.dto.ReviewDTO;
import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieConverter {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewConverter reviewConverter;
    public MovieDTO convertEntityToDto(Movie movie){
        ModelMapper modelMapper = new ModelMapper();
        MovieDTO map = modelMapper.map(movie, MovieDTO.class);
        map.setReviews(movie.getReviews().stream().map(review -> reviewConverter.convertEntityToDto(review)).collect(Collectors.toList()));
        return map;
    }
    public Movie convertDtoToEntity(MovieDTO movieDTO){
        ModelMapper modelMapper = new ModelMapper();
        Movie map = modelMapper.map(movieDTO, Movie.class);
        Movie existingMovie = movieService.getMovie(movieDTO.getId());
        if(movieDTO.getTitle() == null){
            map.setTitle(existingMovie.getTitle());
        }
        if(movieDTO.getDescription() == null){
            map.setDescription(existingMovie.getDescription());
        }
        if(movieDTO.getRuntime() <= 0){
            map.setRuntime(existingMovie.getRuntime());
        }
        return map;
    }
}
