package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.GenreConverter;
import com.dreamix.movieapi.dto.GenreDTO;
import com.dreamix.movieapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreConverter genreConverter;
    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable long id){
        if(genreService.getGenre(id) == null){
            return null;
        }
        return genreConverter.convertEntityToDto(genreService.getGenre(id));
    }
    @GetMapping("/all")
    public List<GenreDTO> getAllGenres(){
        return genreService.getAllGenres().stream().map(genre -> genreConverter.convertEntityToDto(genre)).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public GenreDTO addRecord(@RequestBody GenreDTO genreDTO){
        return genreConverter.convertEntityToDto(genreService.addRecord(genreConverter.convertDtoToEntity(genreDTO)));
    }
    @PutMapping("/update")
    public GenreDTO updateRecord(@RequestBody GenreDTO genreDTO){
        return genreConverter.convertEntityToDto(genreService.updateRecord(genreConverter.convertDtoToEntity(genreDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        genreService.deleteRecord(id);
    }
}
