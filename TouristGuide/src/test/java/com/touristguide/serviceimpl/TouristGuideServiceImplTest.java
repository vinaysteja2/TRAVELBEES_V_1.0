package com.touristguide.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

import com.touristguide.clients.TourClient;
import com.touristguide.dto.TouristGuideDto;
import com.touristguide.entity.TouristGuide;
import com.touristguide.exception.TouristGuideException;
import com.touristguide.repository.TouristGuideRepository;

class TouristGuideServiceImplTest {

	  @Mock
	    private TouristGuideRepository touristGuideRepository;

	    @Mock
	    private TourClient tourClient;

	    @InjectMocks
	    private TouristGuideServiceImpl touristGuideService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    void testAddTouristGuide() {
	        TouristGuide touristGuide = new TouristGuide(null, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");

	        when(touristGuideRepository.existsByEmail("john.doe@example.com")).thenReturn(false);
	        when(touristGuideRepository.save(touristGuide)).thenReturn(touristGuide);

	        TouristGuide addedTouristGuide = touristGuideService.addTouristGuide(touristGuide);
	        assertEquals("John Doe", addedTouristGuide.getName());

	    
	        verify(touristGuideRepository, times(1)).save(touristGuide);

	      
	        when(touristGuideRepository.existsByEmail("john.doe@example.com")).thenReturn(true);

	        assertThrows(TouristGuideException.class, () -> touristGuideService.addTouristGuide(touristGuide));
	    }

	    @Test
	    void testGetTouristGuideById() {
	        Long id = 1L;
	        TouristGuide touristGuide = new TouristGuide(id, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");

	        when(touristGuideRepository.existsById(id)).thenReturn(true);
	        when(touristGuideRepository.findById(id)).thenReturn(java.util.Optional.of(touristGuide));

	        TouristGuideDto foundTouristGuide = touristGuideService.getTouristGuideById(id);
	        assertEquals("John Doe", foundTouristGuide.getName());

	     
	        verify(touristGuideRepository, times(1)).findById(id);

	     
	        Long nonExistentId = 999L;
	        when(touristGuideRepository.existsById(nonExistentId)).thenReturn(false);

	        assertThrows(TouristGuideException.class, () -> touristGuideService.getTouristGuideById(nonExistentId));
	    }

	    @Test
	    void testUpdateTouristGuide() {
	        Long touristGuideId = 1L;
	        TouristGuide existingTouristGuide = new TouristGuide(touristGuideId, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");

	        TouristGuide updatedTouristGuide = new TouristGuide(touristGuideId, "John Updated", "New York Updated",
	                List.of("English", "Spanish"), "Updated description", "john.updated@example.com", 4.7, null,
	                "9876543210", "098765432109");

	        when(touristGuideRepository.existsById(touristGuideId)).thenReturn(true);
	        when(touristGuideRepository.findById(touristGuideId)).thenReturn(java.util.Optional.of(existingTouristGuide));
	        when(touristGuideRepository.save(existingTouristGuide)).thenReturn(existingTouristGuide);

	        touristGuideService.updateTouristGuide(touristGuideId, updatedTouristGuide);
	        assertEquals("John Updated", existingTouristGuide.getName());

	      
	        verify(touristGuideRepository, times(1)).save(existingTouristGuide);

	      
	        Long nonExistentId = 999L;
	        when(touristGuideRepository.existsById(nonExistentId)).thenReturn(false);

	        assertThrows(TouristGuideException.class, () -> touristGuideService.updateTouristGuide(nonExistentId, updatedTouristGuide));
	    }

	    @Test
	    void testDeleteTouristGuide() {
	        Long touristGuideId = 1L;
	        TouristGuide existingTouristGuide = new TouristGuide(touristGuideId, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");

	        when(touristGuideRepository.existsById(touristGuideId)).thenReturn(true);
	        when(touristGuideRepository.findById(touristGuideId)).thenReturn(java.util.Optional.of(existingTouristGuide));

	        touristGuideService.deleteTouristGuide(touristGuideId);

	       
	        verify(touristGuideRepository, times(1)).delete(existingTouristGuide);

	      
	        Long nonExistentId = 999L;
	        when(touristGuideRepository.existsById(nonExistentId)).thenReturn(false);

	        assertThrows(TouristGuideException.class, () -> touristGuideService.deleteTouristGuide(nonExistentId));
	    }

	    @Test
	    void testSearchTouristGuides() {
	        String location = "New York";
	        List<TouristGuide> touristGuides = new ArrayList<>();
	        TouristGuide touristGuide = new TouristGuide(1L, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");
	        touristGuides.add(touristGuide);

	        when(touristGuideRepository.existsByLocation(location)).thenReturn(true);
	        when(touristGuideRepository.findByLocationContainingIgnoreCase(location)).thenReturn(touristGuides);

	        List<TouristGuide> foundTouristGuides = touristGuideService.searchTouristGuides(location);
	        assertEquals(1, foundTouristGuides.size());
	        assertEquals("John Doe", foundTouristGuides.get(0).getName());

	        
	        verify(touristGuideRepository, times(1)).findByLocationContainingIgnoreCase(location);

	     
	        String nonExistentLocation = "Nonexistent City";
	        when(touristGuideRepository.existsByLocation(nonExistentLocation)).thenReturn(false);

	        assertThrows(TouristGuideException.class, () -> touristGuideService.searchTouristGuides(nonExistentLocation));
	    }

	    @Test
	    void testGetAllTouristGuides() {
	        List<TouristGuide> touristGuides = new ArrayList<>();
	        TouristGuide touristGuide1 = new TouristGuide(1L, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");
	        TouristGuide touristGuide2 = new TouristGuide(2L, "Jane Smith", "Los Angeles", List.of("Spanish"),
	                "Tour guide in Los Angeles", "jane.smith@example.com", 4.2, null, "9876543210", "098765432109");
	        touristGuides.add(touristGuide1);
	        touristGuides.add(touristGuide2);

	        when(touristGuideRepository.findAll()).thenReturn(touristGuides);

	        List<TouristGuide> foundTouristGuides = touristGuideService.getAllTouristGuides();
	        assertEquals(2, foundTouristGuides.size());
	        assertEquals("John Doe", foundTouristGuides.get(0).getName());
	        assertEquals("Jane Smith", foundTouristGuides.get(1).getName());

	      
	        verify(touristGuideRepository, times(1)).findAll();

	     
	        when(touristGuideRepository.findAll()).thenReturn(new ArrayList<>());

	        assertThrows(TouristGuideException.class, () -> touristGuideService.getAllTouristGuides());
	    }

	    @Test
	    void testGetAllLocations() {
	        List<TouristGuide> touristGuides = new ArrayList<>();
	        TouristGuide touristGuide1 = new TouristGuide(1L, "John Doe", "New York", List.of("English"),
	                "Tour guide in New York", "john.doe@example.com", 4.5, null, "1234567890", "123456789012");
	        TouristGuide touristGuide2 = new TouristGuide(2L, "Jane Smith", "Los Angeles", List.of("Spanish"),
	                "Tour guide in Los Angeles", "jane.smith@example.com", 4.2, null, "9876543210", "098765432109");
	        touristGuides.add(touristGuide1);
	        touristGuides.add(touristGuide2);

	        when(touristGuideRepository.findAll()).thenReturn(touristGuides);

	        List<String> locations = touristGuideService.getAllLocations();
	        assertEquals(2, locations.size());
	        assertTrue(locations.contains("New York"));
	        assertTrue(locations.contains("Los Angeles"));

	     
	        verify(touristGuideRepository, times(1)).findAll();

	  
	        when(touristGuideRepository.findAll()).thenReturn(new ArrayList<>());

	        assertThrows(TouristGuideException.class, () -> touristGuideService.getAllLocations());
	    }
}
