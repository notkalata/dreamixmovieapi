package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.ReviewDTO;
import com.dreamix.movieapi.dto.ReviewLiteDTO;
import com.dreamix.movieapi.model.Review;
import com.dreamix.movieapi.service.MovieService;
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
    @Autowired
    private MovieService movieService;
    public ReviewDTO convertEntityToDto(Review review){
        ModelMapper modelMapper = new ModelMapper();
        ReviewDTO map = modelMapper.map(review, ReviewDTO.class);
        map.setUser(userConverter.convertEntityToLiteDto(review.getUser()));
        return map;
    }

    public ReviewLiteDTO convertEntityToLiteDto(Review review){
        ModelMapper modelMapper = new ModelMapper();
        ReviewLiteDTO map = modelMapper.map(review, ReviewLiteDTO.class);
        return map;
    }

    public Review convertDtoToEntity(ReviewDTO reviewDTO){
        ModelMapper modelMapper = new ModelMapper();
        Review map = modelMapper.map(reviewDTO, Review.class);
        if(reviewDTO.getId() != null){
            Review existing = reviewService.getReview(reviewDTO.getId());
            existing.setMovie(movieService.getMovie(reviewDTO.getMovieId()));
            map.updateFrom(existing);
        }
        return map;
    }
}
