package com.payment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="Booking",url="http://localhost:8084")
@FeignClient(name="Booking",url="${Booking.url}")
public interface BookingClient {

	 @PutMapping("/bookings/{bookingId}/{id}/payment")
	    ResponseEntity<?> updatePaymentStatus(@PathVariable("bookingId") Long bookingId, @RequestParam("paymentStatus") boolean paymentStatus, @PathVariable("id") Long id);
	
}
