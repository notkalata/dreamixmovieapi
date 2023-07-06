package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.MovieConverter;
import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieConverter movieConverter;
    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable long id){
        return movieConverter.convertEntityToDto(movieService.getMovie(id));
    }
    @GetMapping("/all")
    public List<MovieDTO> getAllMovies(){
        return movieService.getAllMovies().stream().map(movie -> movieConverter.convertEntityToDto(movie)).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public MovieDTO addRecord(@RequestBody MovieDTO movieDTO){
        return movieConverter.convertEntityToDto(movieService.addRecord(movieConverter.convertDtoToEntity(movieDTO)));
    }
    @PutMapping("/update")
    public MovieDTO updateRecord(@RequestBody MovieDTO movieDTO){
        return movieConverter.convertEntityToDto(movieService.updateRecord(movieConverter.convertDtoToEntity(movieDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        movieService.deleteRecord(id);
    }
}
