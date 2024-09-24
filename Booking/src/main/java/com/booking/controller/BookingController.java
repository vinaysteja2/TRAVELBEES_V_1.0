package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.BookingDto;
import com.booking.entity.Booking;

import com.booking.serviceimpl.BookingServiceImpl;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingService;


@GetMapping
public ResponseEntity<List<Booking>> getAllBookings() {
    List<Booking> bookings = bookingService.getAllBookings();
    return new ResponseEntity<>(bookings, HttpStatus.OK);
}

@GetMapping("/{bookingId}")
public ResponseEntity<BookingDto> getBookingById(@PathVariable Long bookingId) {
    BookingDto bookingDto = bookingService.getBookingById(bookingId);
    return new ResponseEntity<>(bookingDto, HttpStatus.OK);
}

@PostMapping("/bookTour/{tourId}")
public ResponseEntity<?> bookTour(@PathVariable Long tourId,  @RequestBody Booking bookingRequest) {
    Booking booking = bookingService.bookTour(tourId, bookingRequest.getUserId(), bookingRequest.getBookingDate(), bookingRequest.getNumberOfPersons());
    if (booking != null) {
        return ResponseEntity.ok().body(booking);
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add tour");
    }
}
@PutMapping("/{bookingId}/{id}/payment")
public ResponseEntity<?> updatePaymentStatus(@PathVariable Long bookingId, @RequestParam boolean paymentStatus,@PathVariable Long id) {
    Booking updatedBooking = bookingService.updatePaymentStatus(bookingId, paymentStatus,id);
    if (updatedBooking != null) {
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
    }
}


@DeleteMapping("/{bookingId}")
public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
    bookingService.deleteBooking(bookingId);

   return ResponseEntity.noContent().build();

}
@GetMapping("/bookings/user/{userId}")
public List<Booking> getBookingsForUser(@PathVariable Long userId) {
    return bookingService.getBookingsForUser(userId);
}

@GetMapping("/{userId}/{tourId}")
public Boolean existsByUserIdAndTourId(Long userId, Long TourId) {
	
	Boolean b= bookingService.existsByUserIdAndTourId( userId,TourId);
	return b;
}

@GetMapping("payment/{paymentId}")
public ResponseEntity<Booking> getBookingByPaymentId(@PathVariable("paymentId") Long paymentId){
	
	  Booking booking = bookingService.getBookingByPaymentId(paymentId);
	    return new ResponseEntity<>(booking, HttpStatus.OK);
}

}


