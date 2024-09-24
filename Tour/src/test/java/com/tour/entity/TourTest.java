package com.tour.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TourTest {

	 @Test
	    void testNoArgsConstructor() {
	        Tour tour = new Tour();
	        assertNotNull(tour);
	    }

	    @Test
	    void testAllArgsConstructor() {
	        Long id = 1L;
	        String name = "Test Tour";
	        String description = "Test Description";
	        Double price = 100.0;
	        Integer duration = 2;
	        Long touristGuideId = 101L;
	        byte[] tourPhoto = new byte[] { 0x1, 0x2, 0x3 };
	        String smallDescription = "Short Description";
	        Double averageRating = 4.5;

	        Tour tour = new Tour(id, name, description, price, duration, touristGuideId, tourPhoto, smallDescription,
	                averageRating);

	        assertEquals(id, tour.getId());
	        assertEquals(name, tour.getName());
	        assertEquals(description, tour.getDescription());
	        assertEquals(price, tour.getPrice());
	        assertEquals(duration, tour.getDuration());
	        assertEquals(touristGuideId, tour.getTouristGuideId());
	        assertEquals(tourPhoto, tour.getTourPhoto());
	        assertEquals(smallDescription, tour.getSmallDescription());
	        assertEquals(averageRating, tour.getAverageRating());
	    }

	    @Test
	    void testGettersAndSetters() {
	        Tour tour = new Tour();

	        Long id = 1L;
	        String name = "Test Tour";
	        String description = "Test Description";
	        Double price = 100.0;
	        Integer duration = 2;
	        Long touristGuideId = 101L;
	        byte[] tourPhoto = new byte[] { 0x1, 0x2, 0x3 };
	        String smallDescription = "Short Description";
	        Double averageRating = 4.5;

	        tour.setId(id);
	        tour.setName(name);
	        tour.setDescription(description);
	        tour.setPrice(price);
	        tour.setDuration(duration);
	        tour.setTouristGuideId(touristGuideId);
	        tour.setTourPhoto(tourPhoto);
	        tour.setSmallDescription(smallDescription);
	        tour.setAverageRating(averageRating);

	        assertEquals(id, tour.getId());
	        assertEquals(name, tour.getName());
	        assertEquals(description, tour.getDescription());
	        assertEquals(price, tour.getPrice());
	        assertEquals(duration, tour.getDuration());
	        assertEquals(touristGuideId, tour.getTouristGuideId());
	        assertEquals(tourPhoto, tour.getTourPhoto());
	        assertEquals(smallDescription, tour.getSmallDescription());
	        assertEquals(averageRating, tour.getAverageRating());
	    }

	    @Test
	    void testToString() {
	        Long id = 1L;
	        String name = "Test Tour";
	        String description = "Test Description";
	        Double price = 100.0;
	        Integer duration = 2;
	        Long touristGuideId = 101L;
	        byte[] tourPhoto = new byte[] { 0x1, 0x2, 0x3 };
	        String smallDescription = "Short Description";
	        Double averageRating = 4.5;

	        Tour tour = new Tour(id, name, description, price, duration, touristGuideId, tourPhoto, smallDescription,
	                averageRating);

	        String expectedToString = "Tour [id=" + id + ", name=" + name + ", description=" + description + ", price="
	                + price + ", duration=" + duration + ", touristGuideId=" + touristGuideId + ", tourPhoto="
	                + Arrays.toString(tourPhoto) + ", smallDescription=" + smallDescription + ", averageRating="
	                + averageRating + "]";

	        assertEquals(expectedToString, tour.toString());
	    }
}
