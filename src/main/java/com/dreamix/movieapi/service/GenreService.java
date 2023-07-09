package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.Genre;
import com.dreamix.movieapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    public Genre getGenre(long id){
        return genreRepository.findById(id);
    }
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
    public Genre addRecord(Genre genre){
        return genreRepository.create(genre);
    }
    public Genre updateRecord(Genre genre){
        return genreRepository.update(genre);
    }
    public void deleteRecord(long id){
        genreRepository.delete(id);
    }
}
