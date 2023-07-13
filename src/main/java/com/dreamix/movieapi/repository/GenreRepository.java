package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class GenreRepository extends BaseRepository<Genre> {
    @Override
    public Class<Genre> getEntityClass() {
        return Genre.class;
    }

    @Override
    public List<Genre> filterByMap(HashMap<String, Object> filter) {
        return null;
    }
}
