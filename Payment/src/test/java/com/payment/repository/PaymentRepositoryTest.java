package com.payment.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PaymentRepositoryTest {

	 @Mock
	    private PaymentRepository paymentRepository;
	 
	   @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	 

	    @Test
	    public void testExistsByBookingId() {
	        Long bookingId = 1L;
	        when(paymentRepository.existsByBookingId(bookingId)).thenReturn(true);

	        boolean exists = paymentRepository.existsByBookingId(bookingId);

	        assertTrue(exists);
	    }

	    @Test
	    public void testNotExistsByBookingId() {
	        Long bookingId = 2L;
	        when(paymentRepository.existsByBookingId(bookingId)).thenReturn(false);

	        boolean exists = paymentRepository.existsByBookingId(bookingId);

	        assertFalse(exists);
	    }
}
