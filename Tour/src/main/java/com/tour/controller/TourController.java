package com.tour.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.tour.entity.Tour;
import com.tour.serviceimpl.TourServiceImpl;

import jakarta.validation.Valid;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tours")
public class TourController {
	
	@Autowired
	private  TourServiceImpl tourServiceImpl;

   
	@PostMapping("/add/{touristGuideId}")
	public ResponseEntity<?> addTourWithTouristGuideId(@PathVariable Long touristGuideId, @Valid @RequestBody Tour tour) {
	    Tour addedTour = tourServiceImpl.addTourWithTouristGuideId(touristGuideId, tour);
	    if (addedTour != null) {
	        return ResponseEntity.ok().body(addedTour);
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add tour");
	    }
	}

    @DeleteMapping("/{tourId}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long tourId) {
        tourServiceImpl.deleteTour(tourId);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/TouristGuideId/{touristGuideId}")
    public ResponseEntity<Void> deleteTourByTouristGuideId(@PathVariable("touristGuideId") Long touristGuideId) {
        try {
            tourServiceImpl.deleteTourByTouristGuideId(touristGuideId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PutMapping("/{tourId}")
    public ResponseEntity<Void> updateTour(@PathVariable Long tourId, @RequestBody Tour updatedTour) {
        tourServiceImpl.updateTour(tourId, updatedTour);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = tourServiceImpl.getAllTours();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @GetMapping("/{tourId}")
    public ResponseEntity<?> getTourById(@PathVariable Long tourId) {
        Tour tour = tourServiceImpl.getTourById(tourId);
    	
        if (tour!=null) {
            return  ResponseEntity.status(HttpStatus.OK).body(tour);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve tour");
        }
    }

    
    
    @GetMapping("/touristGuide/{touristGuideId}")
    public ResponseEntity<?> getToursByTouristGuideId(@PathVariable("touristGuideId" )Long touristGuideId) {
    	
        List<Tour> tours = tourServiceImpl.getToursByTouristGuideId(touristGuideId);
        if (!tours.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.OK).body(tours);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve tourist guide tours");
        }
    }

}
