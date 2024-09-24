package com.payment.service;

import com.payment.entity.Payment;

public interface IPaymentService {

	 public Payment addPaymentForBooking(Long bookingId, Payment payment) ;
	 
//	 public Payment getPaymentById(String paymentId);
//	 
//	 public void deletePayment(String paymentId);
}
