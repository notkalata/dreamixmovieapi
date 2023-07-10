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
    @Autowired
    private ActorConverter actorConverter;
    @Autowired
    private GenreConverter genreConverter;
    public MovieDTO convertEntityToDto(Movie movie){
        ModelMapper modelMapper = new ModelMapper();
        MovieDTO map = modelMapper.map(movie, MovieDTO.class);
        if(movie.getReviews() != null) {
            map.setReviews(movie.getReviews().stream().map(review -> reviewConverter.convertEntityToDto(review)).collect(Collectors.toList()));
        }
        if(movie.getActors() != null){
            map.setActors(movie.getActors().stream().map(actor -> actorConverter.convertEntityToDto(actor)).collect(Collectors.toList()));
        }
        if(movie.getGenres() != null){
            map.setGenres(movie.getGenres().stream().map(genre -> genreConverter.convertEntityToDto(genre)).collect(Collectors.toList()));
        }
        return map;
    }
    public Movie convertDtoToEntity(MovieDTO movieDTO){
        ModelMapper modelMapper = new ModelMapper();
        Movie map = modelMapper.map(movieDTO, Movie.class);
        Movie existingMovie = movieService.getMovie(movieDTO.getId());
        if(existingMovie != null){
            if(movieDTO.getTitle() == null){
                map.setTitle(existingMovie.getTitle());
            }
            if(movieDTO.getDescription() == null){
                map.setDescription(existingMovie.getDescription());
            }
            if(movieDTO.getRuntime() <= 0){
                map.setRuntime(existingMovie.getRuntime());
            }
            if(movieDTO.getReviews() == null){
                map.setReviews(existingMovie.getReviews());
            }
            if(movieDTO.getActors() == null){
                map.setActors(existingMovie.getActors());
            }
            if(movieDTO.getGenres() == null){
                map.setGenres(existingMovie.getGenres());
            }
        }
        if(movieDTO.getReviews() != null){
            map.setReviews(movieDTO.getReviews().stream().map(reviewDTO -> reviewConverter.convertDtoToEntity(reviewDTO)).collect(Collectors.toList()));
        }
        if(movieDTO.getActors() != null){
            map.setActors(movieDTO.getActors().stream().map(actorDTO -> actorConverter.convertDtoToEntity(actorDTO)).collect(Collectors.toList()));
        }
        if(movieDTO.getGenres() != null){
            map.setGenres(movieDTO.getGenres().stream().map(genreDTO -> genreConverter.convertDtoToEntity(genreDTO)).collect(Collectors.toList()));
        }
        return map;
    }
}
