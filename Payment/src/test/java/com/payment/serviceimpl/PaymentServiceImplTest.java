package com.payment.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.payment.clients.BookingClient;
import com.payment.entity.Payment;
import com.payment.entity.PaymentMode;
import com.payment.repository.PaymentRepository;

class PaymentServiceImplTest {

	@Mock
    private PaymentRepository paymentRepository;

    @Mock
    private BookingClient bookingClient;

    @InjectMocks
    private PaymentServiceImpl paymentService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testAddPaymentForBooking() {
        Long bookingId = 1L;
        Payment payment = new Payment(1L, bookingId, 2L, 100.0, PaymentMode.CREDIT_CARD, LocalDate.now(), "PAY123456");

        when(paymentRepository.save(payment)).thenReturn(payment);
//
//        when(bookingClient.updatePaymentStatus(bookingId, true)).thenReturn(payment);

        Payment createdPayment = paymentService.addPaymentForBooking(bookingId, payment);

        assertEquals(payment, createdPayment);
    }
}
