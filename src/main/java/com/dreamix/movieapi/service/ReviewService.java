package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.Review;
import com.dreamix.movieapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    public Review getReview(long id){
        return reviewRepository.findById(id);
    }
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
    public Review addRecord(Review review){
        return reviewRepository.create(review);
    }
    public Review updateRecord(Review review){
        return reviewRepository.update(review);
    }
    public void deleteRecord(long id){
        reviewRepository.delete(id);
    }
}
