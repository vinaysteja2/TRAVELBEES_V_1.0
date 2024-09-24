package com.touristguide.service;

import java.util.List;

import com.touristguide.dto.TouristGuideDto;
import com.touristguide.entity.TouristGuide;

public interface ITouristGuideService {
	
	public TouristGuide addTouristGuide(TouristGuide touristGuide);
	public TouristGuideDto getTouristGuideById(Long id);
	 public void updateTouristGuide(Long touristGuideId, TouristGuide updatedTouristGuide);
	 public void deleteTouristGuide(Long touristGuideId);
	 public List<TouristGuide> searchTouristGuides(String location);
	 public List<TouristGuide> getAllTouristGuides() ;
	 public List<String> getAllLocations();
}
