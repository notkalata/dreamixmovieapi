package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.MovieDTO;
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
        if(movieDTO.getId() != null){
            Movie existing = movieService.getMovie(movieDTO.getId());
            map.updateFrom(existing);
        }
        return map;
    }
}
