package com.booking.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.clients.TourClient;
import com.booking.dto.BookingDto;
import com.booking.entity.Booking;
import com.booking.exception.BookingException;
import com.booking.external.Tour;
import com.booking.mapper.BookingMapper;
import com.booking.repository.BookingRepository;
import com.booking.service.IBookingService;




@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
   @Autowired
	private TourClient tourClient;
    
    public List<Booking> getAllBookings() {
    	
    	 List<Booking> booking= bookingRepository.findAll();
    	 
        if(booking.isEmpty()) {
       	
       	throw new BookingException("There are no bookings Present");
       }
       	
       else {
       	return booking;
       }
       
    }

   
    public BookingDto getBookingById(Long bookingId) {
    	
    	 if(!bookingRepository.existsById(bookingId)) {
 	    	
     		throw new BookingException("Provided booking is not present");
     		
     	}
       Booking booking=bookingRepository.findById(bookingId).get();
       BookingDto bookingDto=this.convertToDto(booking);
       return bookingDto;
        
        	    }
    
     private BookingDto convertToDto(Booking booking) {
        	    	
       Tour tour= tourClient.getTour(booking.getTourId());
       BookingDto bookingDto=BookingMapper.mapToBookingDto(booking,tour);
        return bookingDto;
        
        	    }
        		
     
    

    
    public Booking bookTour(Long tourId, Long userId, LocalDate bookingDate, int numberOfPersons) {
        //List<Booking> existingBookings = bookingRepository.findByTourIdAndBookingDate(tourId, bookingDate);
    	 List<Booking> existingBookings = bookingRepository.findByTourIdAndBookingDateAndPaymentStatusTrue(tourId, bookingDate);
        
        if (!existingBookings.isEmpty()) {
        	throw new BookingException("Provided bookings is not present");
        }

        Booking newBooking = new Booking();
        newBooking.setTourId(tourId);
        newBooking.setUserId(userId);
        newBooking.setBookingDate(bookingDate);
        newBooking.setNumberOfPersons(numberOfPersons);

       
        bookingRepository.save(newBooking);

        return newBooking;
    }

    public void deleteBooking(Long bookingId) {
    	
    	 if(!bookingRepository.existsById(bookingId)) {
  	    	
      		throw new BookingException("Provided booking is not present");
      		
      	}
    	 Booking optionalBooking = bookingRepository.findById(bookingId).get();
        
        bookingRepository.deleteById(bookingId);
        
        if(optionalBooking!=null)
        this.findByTourIdAndBookingDateAndPaymentStatusFalse(optionalBooking.getTourId(),optionalBooking.getBookingDate());
        
        
    }
    public void findByTourIdAndBookingDateAndPaymentStatusFalse(Long tourId ,LocalDate bookingDate){
        
 	   List<Booking> existingBookings = bookingRepository.findByTourIdAndBookingDateAndPaymentStatusFalse(tourId, bookingDate);
 	   
 	   
        for(Booking b:existingBookings) {
     	   b.setBookingStatus("notBooked");
     	   Booking b2=bookingRepository.save(b);
        }
 	   
 	   
     }
     
    
    public Booking updatePaymentStatus(Long bookingId, boolean paymentStatus,Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setPaymentStatus(paymentStatus);
            booking.setBookingStatus("Booked");
            booking.setPaymentId(id);
            Booking b=bookingRepository.save(booking);
            this.findByTourIdAndBookingDateAndPaymentStatusFalse(booking.getTourId(),booking.getBookingDate(),booking.getUserId());
            return b;
        } else {
            return null;
        }
    }
    
   public void findByTourIdAndBookingDateAndPaymentStatusFalse(Long tourId ,LocalDate bookingDate,Long UserId){
    
	   List<Booking> existingBookings = bookingRepository.findByTourIdAndBookingDateAndPaymentStatusFalse(tourId, bookingDate);
	   
	   
       for(Booking b:existingBookings) {
    	   b.setBookingStatus("BookedBy"+UserId);
    	   Booking b2=bookingRepository.save(b);
       }
	   
	   
    }
    
    
    
    
    
    
    public List<Booking> getBookingsForUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

   public Boolean existsByUserIdAndTourId(Long userId, Long TourId) {
	   
	   return bookingRepository.existsByUserIdAndTourId(userId,TourId);
   }
   
   public Booking getBookingByPaymentId(Long paymentId) {

  	 if(!bookingRepository.existsByPaymentId(paymentId)) {
	    	
   		throw new BookingException("Provided booking is not present for paymentId");
   		
   	}
	   return bookingRepository.findByPaymentId(paymentId);
   }
}




