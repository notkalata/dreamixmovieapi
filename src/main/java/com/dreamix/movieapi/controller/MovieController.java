package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.MovieConverter;
import com.dreamix.movieapi.dto.MovieDTO;
import com.dreamix.movieapi.dto.MovieLiteDTO;
import com.dreamix.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieConverter movieConverter;
    // Този метод връща цялата информация за филм, като зарежда всички списъци.
    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable long id){
        if(movieService.getMovie(id) == null){
            return null;
        }
        return movieConverter.convertEntityToDto(movieService.getMovie(id));
    }
    // Този метод връща само базова информация за филм, за да не зарежда всички списъци.
    @GetMapping("/all")
    public List<MovieLiteDTO> getAllMovies(){
        return movieService.getAllMovies().stream().map(movie -> movieConverter.convertEntityToLiteDto(movie)).collect(Collectors.toList());
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
    @GetMapping("/filter")
    public List<MovieLiteDTO> filterMovies(@RequestBody HashMap<String, Object> filter){
        return movieService.filterMovies(filter).stream().map(movie -> movieConverter.convertEntityToLiteDto(movie)).collect(Collectors.toList());
    }
}
