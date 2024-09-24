package com.touristguide.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.touristguide.entity.TouristGuide;
import com.touristguide.serviceimpl.TouristGuideServiceImpl;

class TouristGuideControllerTest {
	
	   @Mock
	    private TouristGuideServiceImpl touristGuideService;

	    @InjectMocks
	    private TouristGuideController touristGuideController;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    void testAddTouristGuide() {
	        TouristGuide touristGuide = new TouristGuide();
	        touristGuide.setName("John Doe");

	        when(touristGuideService.addTouristGuide(any(TouristGuide.class))).thenReturn(touristGuide);

	        ResponseEntity<?> responseEntity = touristGuideController.addTouristGuide(touristGuide);

	        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	        assertEquals(touristGuide, responseEntity.getBody());
	    }

	    @Test
	    void testGetTouristGuideById() {
	        Long touristGuideId = 1L;
	        when(touristGuideService.getTouristGuideById(touristGuideId)).thenReturn(null);

	        ResponseEntity<?> responseEntity = touristGuideController.getTouristGuideById(touristGuideId);

	        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	        assertEquals("touristGuide not found", responseEntity.getBody());
	    }

	    @Test
	    void testUpdateTouristGuide() {
	        Long touristGuideId = 1L;
	        TouristGuide updatedTouristGuide = new TouristGuide();

	        doNothing().when(touristGuideService).updateTouristGuide(eq(touristGuideId), any(TouristGuide.class));

	        ResponseEntity<Void> responseEntity = touristGuideController.updateTouristGuide(touristGuideId, updatedTouristGuide);

	        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	    }

	    @Test
	    void testDeleteTouristGuide() {
	        Long touristGuideId = 1L;

	        doNothing().when(touristGuideService).deleteTouristGuide(touristGuideId);

	        ResponseEntity<Void> responseEntity = touristGuideController.deleteTouristGuide(touristGuideId);

	        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	    }

	    @Test
	    void testSearchTouristGuides() {
	    	String location = "New York";
	        TouristGuide touristGuide1 = new TouristGuide(1L, "John Doe", location, Collections.singletonList("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, new byte[]{}, "1234567890", "123456789012");

	        TouristGuide touristGuide2 = new TouristGuide(2L, "Jane Smith", location, Collections.singletonList("Spanish"),
	                "Tour guide in New York", "jane.smith@example.com", 4.2, new byte[]{}, "9876543210", "098765432109");

	        List<TouristGuide> touristGuides = List.of(touristGuide1, touristGuide2);

	        when(touristGuideService.searchTouristGuides(location)).thenReturn(touristGuides);

	        ResponseEntity<?> responseEntity = touristGuideController.searchTouristGuides(location);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(touristGuides, responseEntity.getBody());
	    }
	    @Test
	    void testGetAllTouristGuidesWithData() {
	        TouristGuide touristGuide1 = new TouristGuide(1L, "John Doe", "New York", Collections.singletonList("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, new byte[]{}, "1234567890", "123456789012");

	        TouristGuide touristGuide2 = new TouristGuide(2L, "Jane Smith", "Los Angeles", Collections.singletonList("Spanish"),
	                "Tour guide in Los Angeles", "jane.smith@example.com", 4.2, new byte[]{}, "9876543210", "098765432109");

	        List<TouristGuide> touristGuides = List.of(touristGuide1, touristGuide2);

	        when(touristGuideService.getAllTouristGuides()).thenReturn(touristGuides);

	        ResponseEntity<?> responseEntity = touristGuideController.getAllTouristGuides();

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(touristGuides, responseEntity.getBody());
	    }

	    @Test
	    void testGetAllLocations() {
	        when(touristGuideService.getAllLocations()).thenReturn(Collections.singletonList("New York"));

	        ResponseEntity<?> responseEntity = touristGuideController.getAllLocations();

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(Collections.singletonList("New York"), responseEntity.getBody());
	    }

}
