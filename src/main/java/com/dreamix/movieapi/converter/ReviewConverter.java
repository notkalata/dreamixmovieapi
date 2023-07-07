package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.ReviewDTO;
import com.dreamix.movieapi.model.Review;
import com.dreamix.movieapi.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserConverter userConverter;
    public ReviewDTO convertEntityToDto(Review review){
        ModelMapper modelMapper = new ModelMapper();
        ReviewDTO map = modelMapper.map(review, ReviewDTO.class);
        map.setUser(userConverter.convertEntityToDto(review.getUser()));
        return map;
    }
    public Review convertDtoToEntity(ReviewDTO reviewDTO){
        ModelMapper modelMapper = new ModelMapper();
        Review map = modelMapper.map(reviewDTO, Review.class);
        Review existingReview = reviewService.getReview(map.getId());
        if(map.getDescription() == null){
            map.setDescription(existingReview.getDescription());
        }
        if(map.getRating() <= 0){
            map.setRating(existingReview.getRating());
        }
        if(map.getUser() == null){
            map.setUser(existingReview.getUser());
        }
        if(map.getMovie() == null){
            map.setMovie(existingReview.getMovie());
        }
        return map;
    }
}
