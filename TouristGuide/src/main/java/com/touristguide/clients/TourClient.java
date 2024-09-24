package com.touristguide.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.touristguide.external.Tour;

//@FeignClient(name="Tour",url="http://localhost:8083")
@FeignClient(name="Tour",url="${Tour.url}")
public interface TourClient {
	
	@GetMapping("/tours/touristGuide/{touristGuideId}")
	List<Tour> getTours(@PathVariable("touristGuideId") Long TouristGuideId);
	 
	@DeleteMapping("tours/TouristGuideId/{touristGuideId}")
	Void deleteTours(@PathVariable("touristGuideId") Long touristGuideId);

}
