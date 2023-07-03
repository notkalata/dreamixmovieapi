package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.model.Movie;
import com.dreamix.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id){
        return movieService.getMovie(id);
    }

    @GetMapping("/all")
    public List<MovieDTO> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/add")
    public Movie addRecord(@RequestBody Movie movie){
        return movieService.addRecord(movie);
    }

    @PutMapping("/update")
    public Movie updateRecord(@RequestBody Movie movie){
        return movieService.updateRecord(movie);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        movieService.deleteRecord(id);
    }
}
