package com.payment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.clients.BookingClient;
import com.payment.entity.Payment;
import com.payment.exception.PaymentException;
import com.payment.repository.PaymentRepository;
import com.payment.service.IPaymentService;


@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingClient bookingClient;


    public Payment addPaymentForBooking(Long bookingId, Payment payment) {
//    	 if(paymentRepository.existsByBookingId(bookingId)) {
//  	    	
//      		throw new PaymentException("Provided booking  is there present");
//      		
//      	}
//      else {
     	 
       
        payment.setBookingId(bookingId);
        Payment paymentDone= paymentRepository.save(payment);
        
        if(paymentDone!=null) {
        	
//        	 ResponseEntity<?> response = 
        			// bookingClient.updatePaymentStatus(bookingId, true);
        	 bookingClient.updatePaymentStatus(bookingId, true,paymentDone.getId());
        	return paymentDone;
        	
        }
        else {
        	return null;
        }
    }

    public Payment getPaymentById(Long id) {
    	 if(!paymentRepository.existsById(id)) {
   	    	
       		throw new PaymentException("Provided payment is not present");
       		
       	}
       else {
    	
        Payment payment = paymentRepository.findById(id).get();
       
    return payment;
    }
    }

//    public void deletePayment(Long paymentId) {
//    	 if(!paymentRepository.existsByBookingId(paymentId)) {
//   	    	
//       		throw new PaymentException("Provided touristGuideId is not present");
//       		
//       	}
//       else {
//        paymentRepository.deleteById(paymentId);
//    }}
}


