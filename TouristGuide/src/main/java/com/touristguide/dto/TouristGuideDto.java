package com.touristguide.dto;

import java.util.List;

import com.touristguide.external.Tour;


public class TouristGuideDto {
	
	
	    private Long id;

	    private String name;

	    private String location;

	    private List<String> languages;

	    private String description;

	    private String email;
	     
	    private Double averageRating;
	    
	    private byte[] photo;
	    
		private String contactNumber;
	    
	    private String aadharNumber;
	    
	   private List<Tour> tour;

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public List<String> getLanguages() {
			return languages;
		}

		public void setLanguages(List<String> languages) {
			this.languages = languages;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Double getAverageRating() {
			return averageRating;
		}

		public void setAverageRating(Double averageRating) {
			this.averageRating = averageRating;
		}

		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photoUrl) {
			this.photo = photoUrl;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getAadharNumber() {
			return aadharNumber;
		}

		public void setAadharNumber(String aadharNumber) {
			this.aadharNumber = aadharNumber;
		}

		public List<Tour> getTour() {
			return tour;
		}

		public void setTour(List<Tour> tour) {
			this.tour = tour;
		}

}
