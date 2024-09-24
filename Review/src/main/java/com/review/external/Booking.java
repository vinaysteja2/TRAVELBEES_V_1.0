package com.review.external;

import java.time.LocalDate;

public class Booking {

	   private Long id;

	   
	    private LocalDate bookingDate;  // Date and time when the booking was made

	    
	    private int numberOfPersons; // Number of persons booked for the tour


		public Booking(Long id, LocalDate bookingDate, int numberOfPersons) {
			super();
			this.id = id;
			this.bookingDate = bookingDate;
			this.numberOfPersons = numberOfPersons;
		}


		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public LocalDate getBookingDate() {
			return bookingDate;
		}


		public void setBookingDate(LocalDate bookingDate) {
			this.bookingDate = bookingDate;
		}


		public int getNumberOfPersons() {
			return numberOfPersons;
		}


		public void setNumberOfPersons(int numberOfPersons) {
			this.numberOfPersons = numberOfPersons;
		}


		@Override
		public String toString() {
			return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", numberOfPersons=" + numberOfPersons + "]";
		}


	
}
