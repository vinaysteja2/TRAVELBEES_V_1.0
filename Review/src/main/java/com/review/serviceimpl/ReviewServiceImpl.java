package com.review.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.clients.BookingClient;
import com.review.entity.Review;
import com.review.exception.ReviewException;
import com.review.repository.ReviewRepository;
import com.review.service.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private  ReviewRepository reviewRepository;
	
    @Autowired
    private BookingClient bookingClinet;
    
    public List<Review> getAllReviews() {
       List<Review> review=reviewRepository.findAll();
        
           if(review.isEmpty()) {
          	
          	throw new ReviewException("There are no reviews Present");
          }
          	
          else {
          	return review;
          }
    }

 
    public Review getReviewById(Long reviewId) {
        
        
        if(!reviewRepository.existsById(reviewId)) {
	    	
    		throw new ReviewException("Provided review is not present");
    		
    	}
	
        return reviewRepository.findById(reviewId).get();     
    }

    
    public void deleteReview(Long reviewId) {
if(!reviewRepository.existsById(reviewId)) {
	    	
    		throw new ReviewException("Provided review is not present");
    		
    	}
else {
	
          reviewRepository.deleteById(reviewId);    
    }

       
    }

   
    
    public Review addReviewToTour(Long tourId, Review review) {
    	
//    if(!reviewRepository.existsByTourId(tourId)) {
//	    	
//    		throw new ReviewException("Provided tourId is not present");
//    		
//    	}
//    else {
    	review.setTourId(tourId); 
        return reviewRepository.save(review);
   // }       
           
     
    }
    
    public Review addReviewToTouristGuide(Long touristGuideId, Review review) {
    	 if(!reviewRepository.existsByTouristGuideId(touristGuideId)) {
 	    	
     		throw new ReviewException("Provided touristGuideId is not present");
     		
     	}
     else {
    	 review.setTouristGuideId(touristGuideId); 
         return reviewRepository.save(review);
     }  
        
    }



    public List<Review> getReviewsByTourId(Long tourId) {
    	 if(!reviewRepository.existsByTourId(tourId)) {
 	    	
     		throw new ReviewException("Provided tourId is not present");
     		
     	}
     else {
    	 return reviewRepository.findByTourId(tourId);
     }    
       
    }
    
    
    public List<Review> getReviewsByTouristGuideId(Long touristGuideId) {
    	
if(!reviewRepository.existsByTouristGuideId(touristGuideId)) {
 	    	
     		throw new ReviewException("Provided touristGuideId is not present");
     		
     	}
     else {
    	 return reviewRepository.findByTouristGuideId(touristGuideId);
     }  
    	
       
    }
    
    public List<Review> getAllReviews(Long tourId) {
    	
    	return reviewRepository.findAll();
    	
    }
}


