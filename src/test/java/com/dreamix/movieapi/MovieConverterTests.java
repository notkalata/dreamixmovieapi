package com.dreamix.movieapi;

import com.dreamix.movieapi.converter.MovieConverter;
import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.dto.MovieLiteDTO;
import com.dreamix.movieapi.model.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MovieConverterTests {
    private final MovieConverter movieConverter = new MovieConverter();
    @Test
    public void checkNullEntity(){
        MovieDTO movieDTO = movieConverter.convertEntityToDto(null);
        MovieLiteDTO movieLiteDTO = movieConverter.convertEntityToLiteDto(null);
        assertNull(movieDTO);
        assertNull(movieLiteDTO);
    }
    @Test
    public void checkNullDTO(){
        Movie movie = movieConverter.convertDtoToEntity(null);
        assertNull(movie);
    }
    @Test
    public void checkEntityToDtoConvert(){
        Movie movie = new Movie("Titanic", "Description", 100,
                null, null, null, null);
        MovieDTO movieDTO = new MovieDTO(null, "Titanic", "Description", 100,
                null, null, null, null);
        MovieDTO expectedDto = movieConverter.convertEntityToDto(movie);
        assertEquals(movieDTO, expectedDto);
    }
    @Test
    public void checkDtoToEntityConvert(){
        MovieDTO movieDTO = new MovieDTO(null, "Titanic", "Description", 100,
                null, null, null, null);
        Movie movie = new Movie("Titanic", "Description", 100,
                null, null, null, null);
        Movie expectedMovie = movieConverter.convertDtoToEntity(movieDTO);
        assertEquals(movie, expectedMovie);
    }
}
