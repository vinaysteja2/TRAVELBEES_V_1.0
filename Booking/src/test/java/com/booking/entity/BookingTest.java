package com.booking.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class BookingTest {

	  @Test
	    public void createBookingTest() {
	      
	        Long id = 1L;
	        Long userId = 1L;
	        Long tourId = 1L;
	        LocalDate bookingDate = LocalDate.now();
	        int numberOfPersons = 2;
	        boolean paymentStatus = false;
	        String bookingStatus="notBooked";
	        Long paymentId=1L;

	        Booking booking = new Booking(id, userId, tourId, bookingDate, numberOfPersons, paymentStatus, bookingStatus,  paymentId);

	       
	        assertEquals(id, booking.getId());
	        assertEquals(userId, booking.getUserId());
	        assertEquals(tourId, booking.getTourId());
	        assertEquals(bookingDate, booking.getBookingDate());
	        assertEquals(numberOfPersons, booking.getNumberOfPersons());
	        assertEquals(paymentStatus, booking.getPaymentStatus());
	    }

	    @Test
	    public void updateBookingTest() {
	     
	        Long id = 1L;
	        Long userId = 1L;
	        Long tourId = 1L;
	        LocalDate bookingDate = LocalDate.now();
	        int numberOfPersons = 2;
	        boolean paymentStatus = false;
	        String bookingStatus="notBooked";
	        Long paymentId=1L;

	        Booking booking = new Booking(id, userId, tourId, bookingDate, numberOfPersons, paymentStatus,bookingStatus , paymentId);

	      
	        booking.setNumberOfPersons(3);
	        booking.setPaymentStatus(true);

	        
	        assertEquals(3, booking.getNumberOfPersons());
	        assertEquals(true, booking.getPaymentStatus());
	    }

	    @Test
	    public void toStringTest() {
	      
	        Long id = 1L;
	        Long userId = 1L;
	        Long tourId = 1L;
	        LocalDate bookingDate = LocalDate.now();
	        int numberOfPersons = 2;
	        boolean paymentStatus = false;
	        String bookingStatus="notBooked";
	        Long paymentId=1L;
	        Booking booking = new Booking(id, userId, tourId, bookingDate, numberOfPersons, paymentStatus, bookingStatus, paymentId);

	     
//	        String expectedToString = "Booking [id=" + id + ", userId=" + userId + ", tourId=" + tourId + ", bookingDate="
//	                + bookingDate + ", numberOfPersons=" + numberOfPersons + ", paymentStatus=" + paymentStatus + "]";
	        String expectedToString =  "Booking [id=" + id + ", userId=" + userId + ", tourId=" + tourId + ", bookingDate=" + bookingDate
	    				+ ", numberOfPersons=" + numberOfPersons + ", paymentStatus=" + paymentStatus + ", bookingStatus="
	    				+ bookingStatus + ", paymentId=" + paymentId + "]";
	    	
	        assertEquals(expectedToString, booking.toString());
	    }
}
