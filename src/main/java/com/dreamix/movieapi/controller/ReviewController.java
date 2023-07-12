package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.ReviewConverter;
import com.dreamix.movieapi.dto.ReviewDTO;
import com.dreamix.movieapi.dto.ReviewLiteDTO;
import com.dreamix.movieapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewConverter reviewConverter;
    // Този метод връща цялата информация за ревю, като зарежда всички списъци.
    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable long id){
        if(reviewService.getReview(id) == null){
            return null;
        }
        return reviewConverter.convertEntityToDto(reviewService.getReview(id));
    }
    // Този метод връща само базова информация за ревю, за да не зарежда всички списъци.
    @GetMapping("/all")
    public List<ReviewLiteDTO> getAllReviews(){
        return reviewService.getAllReviews().stream().map(review -> reviewConverter.convertEntityToLiteDto(review)).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public ReviewDTO addRecord(@RequestBody ReviewDTO reviewDTO){
        return reviewConverter.convertEntityToDto(reviewService.addRecord(reviewConverter.convertDtoToEntity(reviewDTO)));
    }
    @PutMapping("/update")
    public ReviewDTO updateRecord(@RequestBody ReviewDTO reviewDTO){
        return reviewConverter.convertEntityToDto(reviewService.updateRecord(reviewConverter.convertDtoToEntity(reviewDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        reviewService.deleteRecord(id);
    }
}
