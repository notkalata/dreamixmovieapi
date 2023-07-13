package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Review;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReviewRepository extends BaseRepository<Review> {
    @Override
    public Class<Review> getEntityClass() {
        return Review.class;
    }

    @Override
    public List<Review> filterByMap(HashMap<String, Object> filter) {
        return null;
    }
}
