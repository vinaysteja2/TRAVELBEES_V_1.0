package com.tour.service;

import java.util.List;

import com.tour.entity.Tour;

public interface ITourService {
	
	public Tour addTourWithTouristGuideId(Long touristGuideId,Tour tour);
	
	public void deleteTour(Long tourId);
	
	public void updateTour(Long tourId, Tour updatedTour);
	
	public List<Tour> getAllTours();
	
	public Tour getTourById(Long tourId) ;
	
	 public List<Tour> getToursByTouristGuideId(Long touristGuideId);

}
