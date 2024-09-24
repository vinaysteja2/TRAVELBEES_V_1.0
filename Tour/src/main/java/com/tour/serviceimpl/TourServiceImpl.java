package com.tour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.clients.ReviewClient;
import com.tour.dto.ReviewMessage;
import com.tour.entity.Tour;
import com.tour.exception.TourException;
import com.tour.repository.TourRepository;
import com.tour.service.ITourService;


@Service
public class TourServiceImpl implements  ITourService{

	@Autowired  
	private  TourRepository tourRepository;
    
	@Autowired
	private ReviewClient reviewClient;
    
    
	 public Tour addTourWithTouristGuideId(Long touristGuideId,Tour tour) {
	 
	            tour.setTouristGuideId(touristGuideId);
	            tourRepository.save(tour);
	            return tour;
	        
	    }

    public void deleteTour(Long tourId) {
    	
    	 if(!tourRepository.existsById(tourId)) {
		    	
	    		throw new TourException("Provided Tour is not present");
	    		
	    	}
 	
        tourRepository.deleteById(tourId);
    }
 
    public void deleteTourByTouristGuideId(Long touristGuideId) {
    	 if(!tourRepository.existsByTouristGuideId(touristGuideId)) {
		    	
	    		throw new TourException("Provided Tour is not present");
	    		
	    	}
 	
        List<Tour> tours = tourRepository.findByTouristGuideId(touristGuideId);
        for (Tour tour : tours) {
            tourRepository.delete(tour);
        }
        
    }

    public void updateTour(Long tourId, Tour updatedTour) {
    	if(!tourRepository.existsById(tourId)) {
	    	
    		throw new TourException("Provided Tour is not present");
    		
    	}
	
        Tour existingTour = tourRepository.findById(tourId)
                .orElseThrow(() -> new IllegalArgumentException("Tour not found"));

        if (updatedTour.getName() != null) {
            existingTour.setName(updatedTour.getName());
        }
        if (updatedTour.getDescription() != null) {
            existingTour.setDescription(updatedTour.getDescription());
        }
        if (updatedTour.getPrice() != null) {
            existingTour.setPrice(updatedTour.getPrice());
        }
        if (updatedTour.getDuration() != null) {
            existingTour.setDuration(updatedTour.getDuration());
        }
        if (updatedTour.getTourPhoto() != null) {
            existingTour.setTourPhoto(updatedTour.getTourPhoto());
        }

        tourRepository.save(existingTour);
    }
    
    public List<Tour> getAllTours() {
    	List<Tour> tour=tourRepository.findAll(); 
    	  if(tour.isEmpty()) {
          	
          	throw new TourException("There are no touristGuides Present");
          }
          	
          else {
          	return tour;
          }
    }

    
    public Tour getTourById(Long tourId) {
    	if(!tourRepository.existsById(tourId)) {
	    	
    		throw new TourException("Provided Tour is not present");
    		
    	}
	
        return tourRepository.findById(tourId).get();
              
    }
    
    public List<Tour> getToursByTouristGuideId(Long touristGuideId) {
        // Assuming there is a column in Tour entity to store touristGuideId
    	if(!tourRepository.existsByTouristGuideId(touristGuideId)) {
	    	
    		throw new TourException("Provided Tour is not present");
    		
    	}
	
        return tourRepository.findByTouristGuideId(touristGuideId);
    }
    
    public void updateTourRating(ReviewMessage reviewMessage) {
    	
    	System.out.println(reviewMessage.getComment()+" -------------------------------------------------------------------------------------------------------------------------------------------------");
		
    	Double averageRating=reviewClient.getAverageRatingForTour(reviewMessage.getTourId());
    	System.out.println(averageRating+" :0fffffffffffffffffff--------------------------------------------------------------------------------------------------------------------------");
		
    }
}


