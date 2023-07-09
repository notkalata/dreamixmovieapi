package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreRepository extends BaseRepository<Genre> {
    @Override
    public Class<Genre> getEntityClass() {
        return Genre.class;
    }
}
