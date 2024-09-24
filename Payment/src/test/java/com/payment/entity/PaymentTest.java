package com.payment.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PaymentTest {

	 @Test
	    public void createPaymentTest() {
	        
	        Long id = 1L;
	        Long bookingId = 1L;
	        Long totalNoOfPersons = 2L;
	        double totalPrice = 100.0;
	        PaymentMode paymentMode = PaymentMode.CREDIT_CARD;
	        LocalDate paymentDate = LocalDate.now();
	        String paymentId = "PAY123456";

	        Payment payment = new Payment(id, bookingId, totalNoOfPersons, totalPrice, paymentMode, paymentDate, paymentId);

	        
	        assertEquals(id, payment.getId());
	        assertEquals(bookingId, payment.getBookingId());
	        assertEquals(totalNoOfPersons, payment.getTotalNoOfPersons());
	        assertEquals(totalPrice, payment.getTotalPrice());
	        assertEquals(paymentMode, payment.getPaymentMode());
	        assertEquals(paymentDate, payment.getPaymentDate());
	        assertEquals(paymentId, payment.getPaymentId());
	    }

	    @Test
	    public void updatePaymentTest() {
	      
	        Long id = 1L;
	        Long bookingId = 1L;
	        Long totalNoOfPersons = 2L;
	        double totalPrice = 100.0;
	        PaymentMode paymentMode = PaymentMode.CREDIT_CARD;
	        LocalDate paymentDate = LocalDate.now();
	        String paymentId = "PAY123456";

	        Payment payment = new Payment(id, bookingId, totalNoOfPersons, totalPrice, paymentMode, paymentDate, paymentId);

	    
	        payment.setTotalPrice(120.0);
	        payment.setPaymentMode(PaymentMode.DEBIT_CARD);

	       
	        assertEquals(120.0, payment.getTotalPrice());
	        assertEquals(PaymentMode.DEBIT_CARD, payment.getPaymentMode());
	    }

	    @Test
	    public void toStringTest() {
	        
	        Long id = 1L;
	        Long bookingId = 1L;
	        Long totalNoOfPersons = 2L;
	        double totalPrice = 100.0;
	        PaymentMode paymentMode = PaymentMode.CREDIT_CARD;
	        LocalDate paymentDate = LocalDate.now();
	        String paymentId = "PAY123456";

	        Payment payment = new Payment(id, bookingId, totalNoOfPersons, totalPrice, paymentMode, paymentDate, paymentId);

	      
	        String expectedToString = "Payment [id=" + id + ", bookingId=" + bookingId + ", totalNoOfPersons="
	                + totalNoOfPersons + ", totalPrice=" + totalPrice + ", paymentMode=" + paymentMode + ", paymentDate="
	                + paymentDate + ", paymentId=" + paymentId + "]";
	        assertEquals(expectedToString, payment.toString());
	    }

}
