package com.review.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReviewTest {

	 @Test
	    public void testReviewConstructor() {
	        
	        Review review = new Review(1L, 1L, 2L, null, "Great tour", 5);

	     
	        assertNotNull(review, "Review object should not be null");
	        assertEquals(1L, review.getId(), "Id should match");
	        assertEquals(1L, review.getUserId(), "User ID should match");
	        assertEquals(2L, review.getTourId(), "Tour ID should match");
	        assertEquals(null, review.getTouristGuideId(), "Tourist Guide ID should be null");
	        assertEquals("Great tour", review.getComment(), "Comment should match");
	        assertEquals(5, review.getRating(), "Rating should match");
	    }
	 
	 @Test
	    public void testReviewGettersAndSetters() {
	       
	        Review review = new Review();

	      
	        review.setId(1L);
	        review.setUserId(1L);
	        review.setTourId(2L);
	        review.setTouristGuideId(null);
	        review.setComment("Great tour");
	        review.setRating(5);

	       
	        assertEquals(1L, review.getId(), "Id should match");
	        assertEquals(1L, review.getUserId(), "User ID should match");
	        assertEquals(2L, review.getTourId(), "Tour ID should match");
	        assertEquals(null, review.getTouristGuideId(), "Tourist Guide ID should be null");
	        assertEquals("Great tour", review.getComment(), "Comment should match");
	        assertEquals(5, review.getRating(), "Rating should match");
	    }
	 
	 @Test
	    public void testReviewToString() {
	      
	        Review review = new Review(1L, 1L, 2L, null, "Great tour", 5);

	       
	        String expectedToString = "Review [id=1, userId=1, tourId=2, touristGuideId=null, comment=Great tour, rating=5]";

	      
	        assertEquals(expectedToString, review.toString(), "toString method should return expected string representation");
	    }
}
