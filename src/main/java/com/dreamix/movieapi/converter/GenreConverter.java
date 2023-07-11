package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.GenreDTO;
import com.dreamix.movieapi.model.Genre;
import com.dreamix.movieapi.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter {
    @Autowired
    private GenreService genreService;
    public GenreDTO convertEntityToDto(Genre genre){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(genre, GenreDTO.class);
    }
    public Genre convertDtoToEntity(GenreDTO genreDTO){
        ModelMapper modelMapper = new ModelMapper();
        Genre map = modelMapper.map(genreDTO, Genre.class);
        if(genreDTO.getId() != null){
            Genre existing = genreService.getGenre(genreDTO.getId());
            map.updateFrom(existing);
        }
        return map;
    }
}
