package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.ReviewDTO;
import com.dreamix.movieapi.model.Review;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    @Autowired
    private UserConverter userConverter;
    public ReviewDTO convertEntityToDto(Review review){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(review, ReviewDTO.class);
    }
    public Review convertDtoToEntity(ReviewDTO reviewDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reviewDTO, Review.class);
    }
}
