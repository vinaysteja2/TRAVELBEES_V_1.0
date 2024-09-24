package com.tour.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Review",url="${Review.url}")
public interface ReviewClient {
	
	@GetMapping("/reviews/averageRating")
	Double getAverageRatingForTour(@RequestParam("tourId") Long tourId);
	

}
