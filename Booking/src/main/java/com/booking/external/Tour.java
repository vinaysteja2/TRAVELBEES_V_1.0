package com.booking.external;

public class Tour {
	
    private Long id;
 
    private String name;

    private String description;

    private Double price;

    private Integer duration;
    
   private Long touristGuideId;

    private String tourPhoto;

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

	public String getTourPhoto() {
		return tourPhoto;
	}

	public void setTourPhoto(String tourPhoto) {
		this.tourPhoto = tourPhoto;
	}

	public Long getTouristGuideId() {
		return touristGuideId;
	}

	public void setTouristGuideId(Long touristGuideId) {
		this.touristGuideId = touristGuideId;
	}


 
}
