package com.booking.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.booking.external.Tour;



//@FeignClient(name="Tour",url="http://localhost:8083")
@FeignClient(name="Tour",url="${Tour.url}")
public interface TourClient {
	
	@GetMapping("/tours/{tourId}")
	Tour getTour(@PathVariable("tourId") Long TourId);
	

}
