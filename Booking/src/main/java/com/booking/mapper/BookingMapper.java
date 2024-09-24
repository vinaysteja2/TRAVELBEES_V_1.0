package com.booking.mapper;

import com.booking.dto.BookingDto;
import com.booking.entity.Booking;
import com.booking.external.Tour;

public class BookingMapper {
	
	public static BookingDto mapToBookingDto(Booking booking ,Tour tour) {
		
		BookingDto bookingDto=new BookingDto(); 
		
		bookingDto.setId(booking.getId());
		bookingDto.setBookingDate(booking.getBookingDate());
		bookingDto.setNumberOfPersons(booking.getNumberOfPersons());
		bookingDto.setUserId(booking.getUserId());
		bookingDto.setPaymentId(booking.getPaymentId());
		bookingDto.setPaymentStatus(booking.getPaymentStatus());
		bookingDto.setTour(tour);
		return bookingDto;
		
	}

}
