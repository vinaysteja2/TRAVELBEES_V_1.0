package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.entity.Review;
import com.review.external.ReviewMessageProducer;
import com.review.serviceimpl.ReviewServiceImpl;

import jakarta.validation.Valid;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl reviewService;
	
	@Autowired
	private ReviewMessageProducer reviewMessageProducer;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

   

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }


    
    @PostMapping("/addReviewToTour/{tourId}")
    public ResponseEntity<?> addReviewToTour(@PathVariable("tourId") Long tourId, @RequestBody Review review) {
       
            Review tourReview = reviewService.addReviewToTour(tourId, review);
            if( tourReview!=null) {
            	reviewMessageProducer.sendMessage(tourReview);
            return ResponseEntity.status(HttpStatus.CREATED).body(tourReview);
            }
            else {
            	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no review to add to tour.");
            }
            // Log the exception or handle it based on your requirements
    }
    
    
    @PostMapping("/addReviewToTouristGuide/{touristGuideId}")
    public ResponseEntity<?> addReviewToTouristGuide(@PathVariable("touristGuideId") Long touristGuideId, @Valid @RequestBody Review review) {
        try {
            Review guideReview = reviewService.addReviewToTouristGuide(touristGuideId, review);
            if (guideReview != null)
                return ResponseEntity.status(HttpStatus.CREATED).body(guideReview);
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No review to add to the tourist guide.");
            }
        } catch (Exception e) {
            // Log the exception or handle it based on your requirements
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add review to tourist guide.");
        }}  
        
        
        @GetMapping("/getTourReviews/{tourId}")
        public ResponseEntity<?> getReviewsByTourId(@PathVariable Long tourId) {
        	try {
            List<Review> reviews = reviewService.getReviewsByTourId(tourId);
            if(!reviews.isEmpty()) {
            	return ResponseEntity.status(HttpStatus.CREATED).body(reviews);
            }
            else {
            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No reviews to tour.");
            }
            
        }catch(Exception e) {
        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get review to tour.");
        }
}
        
        
        @GetMapping("/gettouristGuideReviews/{touristGuideId}")
        public ResponseEntity<?> getReviewsByTouristGuideId(@PathVariable Long touristGuideId) {
           
            try {
            	 List<Review> reviews = reviewService.getReviewsByTouristGuideId(touristGuideId);
                if(!reviews.isEmpty()) {
                	return ResponseEntity.status(HttpStatus.CREATED).body(reviews);
                }
                else {
                	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No reviews to touristGuide.");
                }
                
            }catch(Exception e) {
            	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get review to touristGuide.");
            }
        }
        
        @GetMapping("/averageRating")
        public Double getAverageReview(@RequestParam Long tourId) {
        	
       List<Review> reviewList=reviewService.getAllReviews(tourId);
       
       return reviewList.stream().mapToDouble(Review::getRating).average().orElse(0.0);
        }
        
}