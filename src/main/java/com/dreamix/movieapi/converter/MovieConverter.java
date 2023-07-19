package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.dto.MovieLiteDTO;
import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class MovieConverter {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewConverter reviewConverter;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private final ModelMapper modelMapper = new ModelMapper();
    public MovieDTO convertEntityToDto(Movie movie){
        if(movie == null){
            return null;
        }
        MovieDTO map = modelMapper.map(movie, MovieDTO.class);
        if(movie.getReviews() != null){
            map.setReviews(movie.getReviews().stream().map(review -> reviewConverter.convertEntityToLiteDto(review)).collect(Collectors.toList()));
        }
        if(movie.getReleaseDate() != null){
            map.setReleaseDate(movie.getReleaseDate().format(dateTimeFormatter));
        }
        return map;
    }

    public MovieLiteDTO convertEntityToLiteDto(Movie movie){
        if(movie == null){
            return null;
        }
        MovieLiteDTO map = modelMapper.map(movie, MovieLiteDTO.class);
        if(movie.getReleaseDate() != null){
            map.setReleaseDate(movie.getReleaseDate().format(dateTimeFormatter));
        }
        return map;
    }

    public Movie convertDtoToEntity(MovieDTO movieDTO){
        if(movieDTO == null){
            return null;
        }
        Movie map = modelMapper.map(movieDTO, Movie.class);
        if(movieDTO.getId() != null){
            Movie existing = movieService.getMovie(movieDTO.getId());
            map.updateFrom(existing);
        }
        if(movieDTO.getReleaseDate() != null) {
            map.setReleaseDate(LocalDate.parse(movieDTO.getReleaseDate(), dateTimeFormatter));
        }
        return map;
    }
}
