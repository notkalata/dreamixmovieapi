package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Review;
import org.springframework.stereotype.Repository;
@Repository
public class ReviewRepository extends BaseRepository<Review> {
    @Override
    public Class<Review> getEntityClass() {
        return Review.class;
    }
}
