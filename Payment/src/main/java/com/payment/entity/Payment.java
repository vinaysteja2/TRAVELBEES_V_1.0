package com.payment.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payments1")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Booking ID is required")
    private Long bookingId;

    @NotNull(message = "Total number of persons is required")
    @Min(value = 1, message = "Total number of persons must be at least 1")
    private Long totalNoOfPersons;

    @NotNull(message = "Total price is required")
    @Min(value = 0, message = "Total price must be greater than or equal to 0")
    private double totalPrice;

    // Uncomment if using EnumType.STRING for paymentMode
     @Enumerated(EnumType.STRING)
     private PaymentMode paymentMode;

    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate; // Current date of payment

//    @NotBlank(message = "Payment ID is required")
    private String paymentId;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Payment(Long id, @NotNull(message = "Booking ID is required") Long bookingId,
			@NotNull(message = "Total number of persons is required") @Min(value = 1, message = "Total number of persons must be at least 1") Long totalNoOfPersons,
			@NotNull(message = "Total price is required") @Min(value = 0, message = "Total price must be greater than or equal to 0") double totalPrice,
			PaymentMode paymentMode, @NotNull(message = "Payment date is required") LocalDate paymentDate,
			@NotBlank(message = "Payment ID is required") String paymentId) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.totalNoOfPersons = totalNoOfPersons;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.paymentId = paymentId;
	}












	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}







	public Long getTotalNoOfPersons() {
		return totalNoOfPersons;
	}







	public void setTotalNoOfPersons(Long totalNoOfPersons) {
		this.totalNoOfPersons = totalNoOfPersons;
	}






	public String getPaymentId() {
		return paymentId;
	}






	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}







	@Override
	public String toString() {
		return "Payment [id=" + id + ", bookingId=" + bookingId + ", totalNoOfPersons=" + totalNoOfPersons
				+ ", totalPrice=" + totalPrice + ", paymentMode=" + paymentMode + ", paymentDate=" + paymentDate
				+ ", paymentId=" + paymentId + "]";
	}






	

}