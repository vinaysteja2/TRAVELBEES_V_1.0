package com.tour.dto;



public class ReviewMessage {

	private Long id;
	
	 private Long userId;  

	 private Long tourId;  

	 private Long touristGuideId;  

	 private String comment; 

	 private int rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTourId() {
		return tourId;
	}

	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

	public Long getTouristGuideId() {
		return touristGuideId;
	}

	public void setTouristGuideId(Long touristGuideId) {
		this.touristGuideId = touristGuideId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	} 


}
