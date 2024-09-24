package com.tour.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tour.entity.Tour;
import com.tour.serviceimpl.TourServiceImpl;

public class TourRepositoryTest{

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourServiceImpl tourService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    void testFindByTouristGuideId() {
        Long touristGuideId = 1L;

       
        Tour tour1 = new Tour(1L, "Tour 1", "Description 1", 100.0, 2, touristGuideId, null, "Small Description 1", 4.5);
        Tour tour2 = new Tour(2L, "Tour 2", "Description 2", 150.0, 3, touristGuideId, null, "Small Description 2", 4.0);

        List<Tour> expectedTours = new ArrayList<>();
        expectedTours.add(tour1);
        expectedTours.add(tour2);

  

            when(tourRepository.findByTouristGuideId(touristGuideId)).thenReturn(expectedTours);

            List<Tour> actualTours = tourRepository.findByTouristGuideId(touristGuideId);

            assertEquals(expectedTours, actualTours);
        }
   
    
    @Test
    void testDeleteByTouristGuideId() {
        Long touristGuideId = 1L;

        doNothing().when(tourRepository).deleteByTouristGuideId(touristGuideId);

        assertDoesNotThrow(() -> tourRepository.deleteByTouristGuideId(touristGuideId));

        verify(tourRepository, times(1)).deleteByTouristGuideId(touristGuideId);
    }

    @Test
    void testDeleteTourByTouristGuideId() {
        Long touristGuideId = 1L;

        doNothing().when(tourRepository).deleteTourByTouristGuideId(touristGuideId);

        assertDoesNotThrow(() -> tourRepository.deleteTourByTouristGuideId(touristGuideId));

        verify(tourRepository, times(1)).deleteTourByTouristGuideId(touristGuideId);
    }

    @Test
    void testExistsByTouristGuideId() {
        Long touristGuideId = 1L;

        when(tourRepository.existsByTouristGuideId(touristGuideId)).thenReturn(true);

        boolean exists = tourRepository.existsByTouristGuideId(touristGuideId);

        assertTrue(exists);
    }

}