package com.payment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.payment.entity.Payment;
import com.payment.serviceimpl.PaymentServiceImpl;

class PaymentControllerTest {

	@Mock
    private PaymentServiceImpl paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddPaymentForBooking() {
        Long bookingId = 1L;
        Payment payment = new Payment();
        payment.setBookingId(bookingId);

        when(paymentService.addPaymentForBooking(bookingId, payment)).thenReturn(payment);

        ResponseEntity<?> responseEntity = paymentController.addPaymentForBooking(bookingId, payment);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(payment, responseEntity.getBody());
    }
}
