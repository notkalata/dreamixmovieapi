package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.model.Movie;
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
    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable long id){
        return new MovieDTO(movieService.getMovie(id));
    }
    @GetMapping("/all")
    public List<MovieDTO> getAllMovies(){
        return movieService.getAllMovies().stream().map(MovieDTO::new).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public MovieDTO addRecord(@RequestBody Movie movie){
        return new MovieDTO(movieService.addRecord(movie));
    }
    @PutMapping("/update")
    public MovieDTO updateRecord(@RequestBody Movie movie){
        return new MovieDTO(movieService.updateRecord(movie));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        movieService.deleteRecord(id);
    }
}
