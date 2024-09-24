package com.review.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.review.external.Booking;

//@FeignClient(name="Booking",url="http://localhost:8084")
@FeignClient(name="Booking",url="${Booking.url}")
public interface BookingClient {
	
//	@GetMapping("/bookings/{userId}/{tourId}")
//	boolean getBooking(@PathVariable("userId") Long userId, @PathVariable("tourId") Long tourId);

}
