package com.tour.entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tours1")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
   
    @NotBlank(message = "Tour name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Double price;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be greater than 0")
    private Integer duration; // Duration in hours, days, etc.

    //@NotNull(message = "Tourist guide ID is required")
    private Long touristGuideId;

    @Lob
    private byte[] tourPhoto;

    @NotBlank(message = "Small description is required")
    private String smallDescription;

    @NotNull(message = "Average rating is required")
    @DecimalMin(value = "0.0", message = "Average rating must be greater than or equal to 0")
    @DecimalMax(value = "5.0", message = "Average rating must be less than or equal to 5")
    private Double averageRating;
  
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}




public Tour(Long id, String name, String description, Double price, Integer duration, Long touristGuideId,
		byte[] tourPhoto, String smallDescription, Double averageRating) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.duration = duration;
	this.touristGuideId = touristGuideId;
	this.tourPhoto = tourPhoto;
	this.smallDescription = smallDescription;
	this.averageRating = averageRating;
}




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


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


public Integer getDuration() {
	return duration;
}


public void setDuration(Integer duration) {
	this.duration = duration;
}


public Long getTouristGuideId() {
	return touristGuideId;
}


public void setTouristGuideId(Long touristGuideId) {
	this.touristGuideId = touristGuideId;
}


public byte[] getTourPhoto() {
	return tourPhoto;
}


public void setTourPhoto(byte[] tourPhoto) {
	this.tourPhoto = tourPhoto;
}




public String getSmallDescription() {
	return smallDescription;
}




public void setSmallDescription(String smallDescription) {
	this.smallDescription = smallDescription;
}




public Double getAverageRating() {
	return averageRating;
}




public void setAverageRating(Double averageRating) {
	this.averageRating = averageRating;
}




@Override
public String toString() {
	return "Tour [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", duration="
			+ duration + ", touristGuideId=" + touristGuideId + ", tourPhoto=" + Arrays.toString(tourPhoto)
			+ ", smallDescription=" + smallDescription + ", averageRating=" + averageRating + "]";
}



   
}


