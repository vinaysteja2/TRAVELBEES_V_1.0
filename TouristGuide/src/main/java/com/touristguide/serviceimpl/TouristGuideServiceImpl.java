package com.touristguide.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touristguide.clients.TourClient;
import com.touristguide.dto.TouristGuideDto;
import com.touristguide.entity.TouristGuide;
import com.touristguide.exception.TouristGuideException;
import com.touristguide.external.Tour;
import com.touristguide.mapper.TouristGuideMapper;
import com.touristguide.repository.TouristGuideRepository;
import com.touristguide.service.ITouristGuideService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class TouristGuideServiceImpl implements ITouristGuideService {
	
	@Autowired
    private  TouristGuideRepository touristGuideRepository;

	@Autowired
	private TourClient tourClient;
   
	int attempt=0;

	 public TouristGuide addTouristGuide(TouristGuide touristGuide) {
	        if (touristGuideRepository.existsByEmail(touristGuide.getEmail())) {
	            throw new TouristGuideException("Email is already in use");
	        }
	        return touristGuideRepository.save(touristGuide);
	    }
	
	 //circuit breaker and fallback mechanism
//	 @CircuitBreaker(name="tourBreaker",fallbackMethod="tourBreakerFallback")
	 //retry mechanism
//	 @Retry(name="tourBreaker",fallbackMethod="tourBreakerFallback")
	 
	 //rate limiting mechanism
	 @RateLimiter(name="tourBreaker",fallbackMethod="tourBreakerFallback")
	  public TouristGuideDto getTouristGuideById(Long id) {
		 System.out.println("number of attempts: "+ ++attempt);
		  if(!touristGuideRepository.existsById(id)) {
	    	
	    		throw new TouristGuideException("Provided TouristGuide is not present");
	    		
	    	}
		  TouristGuide touristGuide= touristGuideRepository.findById(id).get();
	    	return this.convertToDto( touristGuide);
	    
	  }
//	 if Tour Microservice is not working if it is in off state.
//	 i want to return a list containing with messages.whatever the name mentioned in the "fallbackMethod="tourBreakerFallback"  
//	 same method name should have here also.
//	 The method signature of the fallback method should match the original method. Since your original method getTouristGuideById returns a TouristGuideDto,
//	 your fallback method should also return a TouristGuideDto (or something that can be used as a fallback response).
//	 The first parameter of the fallback method should be the same as the parameters of the original method.
//	 The second parameter of the fallback method is typically the Throwable or Exception that caused the fallback to be triggered.
//	 
//	 
//	 public TouristGuideDto tourBreakerFallback(Long id, Exception e) {
//		    // Construct a fallback TouristGuideDto
//		    TouristGuideDto fallbackDto = new TouristGuideDto();
//		    fallbackDto.setId(id);
//		    fallbackDto.setName("Tour microservice is not working, providing fallback data.");
//		    return fallbackDto;
//		}
	 
	 //for ratelimiter
	 
	 public TouristGuideDto tourBreakerFallback(Long id,  Exception e) {
	    // Construct a fallback TouristGuideDto
	    TouristGuideDto fallbackDto = new TouristGuideDto();
	    fallbackDto.setId(id);
	    fallbackDto.setName("number of attempts exceeded");
	    return fallbackDto;
	}
	  
    private TouristGuideDto convertToDto(TouristGuide touristGuide) {
	
	List<Tour> tours= tourClient.getTours(touristGuide.getId());
   TouristGuideDto touristGuideDto=TouristGuideMapper.mapToTouristGuideDto(touristGuide,tours);
     return touristGuideDto;
}
	    	
    public TouristGuide getTouristGuideById1(Long id) {
		  if(!touristGuideRepository.existsById(id)) {
	    	
	    		throw new TouristGuideException("Provided TouristGuide is not present");
	    		
	    	}
		  TouristGuide touristGuide= touristGuideRepository.findById(id).get();
	    	return touristGuide;
	    
	  }
	  
    
    public void updateTouristGuide(Long touristGuideId, TouristGuide updatedTouristGuide) {
        
        		  if(!touristGuideRepository.existsById(touristGuideId)) {
        		    	
      	    		throw new TouristGuideException("Provided TouristGuide is not present");
      	    		
      	    	}
        TouristGuide existingTouristGuide = touristGuideRepository.findById(touristGuideId).get();
        
        existingTouristGuide.setName(updatedTouristGuide.getName());
        existingTouristGuide.setLocation(updatedTouristGuide.getLocation());
        existingTouristGuide.setLanguages(updatedTouristGuide.getLanguages());
        existingTouristGuide.setDescription(updatedTouristGuide.getDescription());
        existingTouristGuide.setEmail(updatedTouristGuide.getEmail());
        existingTouristGuide.setAverageRating(updatedTouristGuide.getAverageRating());
        existingTouristGuide.setPhoto(updatedTouristGuide.getPhoto());
        existingTouristGuide.setContactNumber(updatedTouristGuide.getContactNumber());

       
        touristGuideRepository.save(existingTouristGuide);
    }

    public void deleteTouristGuide(Long touristGuideId) {
    	
    	  if(!touristGuideRepository.existsById(touristGuideId)) {
		    	
	    		throw new TouristGuideException("Provided TouristGuide is not present");
	    		
	    	}
    	
        TouristGuide existingTouristGuide = touristGuideRepository.findById(touristGuideId).get();
        tourClient.deleteTours(touristGuideId); 
        touristGuideRepository.delete(existingTouristGuide);
    }

    public List<TouristGuide> searchTouristGuides(String location) {
    	
    	if(!touristGuideRepository.existsByLocation(location)) {
	    	
    		throw new TouristGuideException("Provided TouristGuide location is not present");
    		
    	}
        return touristGuideRepository.findByLocationContainingIgnoreCase(location);
    }
    

    
    public List<TouristGuide> getAllTouristGuides() {
        
        List<TouristGuide> touristGuides = touristGuideRepository.findAll();
        
        if(touristGuides.isEmpty()) {
        	
        	throw new TouristGuideException("There are no touristGuides Present");
        }
        	
        else {
        	return touristGuides;
        }}
    
    public List<String> getAllLocations() {
        List<TouristGuide> touristGuides = touristGuideRepository.findAll();
         if(touristGuides.isEmpty()) {
        	
        	throw new TouristGuideException("There are no touristGuides Present in this location");
        }
        	
        else {
        return touristGuides.stream()
                .map(TouristGuide::getLocation)
                .distinct()
                .collect(Collectors.toList());
    }
}
}
