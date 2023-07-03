package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository extends BaseRepository<Movie> {
    @Override
    public Class<Movie> getEntityClass() {
        return Movie.class;
    }
}
