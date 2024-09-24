package com.review.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.review.entity.Review;

class ReviewRepositoryTest {

	@Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByTourId() {
        Long tourId = 1L;
        List<Review> reviews = Collections.singletonList(new Review(1L, 1L, tourId, null, "Great tour", 5));

       
        when(reviewRepository.findByTourId(tourId)).thenReturn(reviews);

        List<Review> result = reviewRepository.findByTourId(tourId);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(tourId, result.get(0).getTourId());
    }

    @Test
    public void testFindByTouristGuideId() {
        Long touristGuideId = 1L;
        List<Review> reviews = Collections.singletonList(new Review(1L, 1L, null, touristGuideId, "Excellent guide", 5));

      
        when(reviewRepository.findByTouristGuideId(touristGuideId)).thenReturn(reviews);

        List<Review> result = reviewRepository.findByTouristGuideId(touristGuideId);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(touristGuideId, result.get(0).getTouristGuideId());
    }

    @Test
    public void testExistsByTourId_Exists() {
        Long tourId = 1L;

      
        when(reviewRepository.existsByTourId(tourId)).thenReturn(true);

        assertTrue(reviewRepository.existsByTourId(tourId));
    }

    @Test
    public void testExistsByTourId_NotExists() {
        Long tourId = 1L;

    
        when(reviewRepository.existsByTourId(tourId)).thenReturn(false);

        assertFalse(reviewRepository.existsByTourId(tourId));
    }

    @Test
    public void testExistsByTouristGuideId_Exists() {
        Long touristGuideId = 1L;

      
        when(reviewRepository.existsByTouristGuideId(touristGuideId)).thenReturn(true);

        assertTrue(reviewRepository.existsByTouristGuideId(touristGuideId));
    }

    @Test
    public void testExistsByTouristGuideId_NotExists() {
        Long touristGuideId = 1L;

     
        when(reviewRepository.existsByTouristGuideId(touristGuideId)).thenReturn(false);

        assertFalse(reviewRepository.existsByTouristGuideId(touristGuideId));
    }

}
