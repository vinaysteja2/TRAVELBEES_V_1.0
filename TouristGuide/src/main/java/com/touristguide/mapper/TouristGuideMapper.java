package com.touristguide.mapper;

import java.util.List;

import com.touristguide.dto.TouristGuideDto;
import com.touristguide.entity.TouristGuide;
import com.touristguide.external.Tour;

public class TouristGuideMapper {
	
	public static TouristGuideDto mapToTouristGuideDto(TouristGuide touristGuide ,List<Tour> tour) {
		
		TouristGuideDto touristGuideDto=new TouristGuideDto(); 
		
		touristGuideDto.setId(touristGuide.getId());
		touristGuideDto.setName(touristGuide.getName());
		touristGuideDto.setLocation(touristGuide.getLocation());
		touristGuideDto.setLanguages(touristGuide.getLanguages());
		touristGuideDto.setDescription(touristGuide.getDescription());
		touristGuideDto.setEmail(touristGuide.getEmail());
		touristGuideDto.setAverageRating(touristGuide.getAverageRating());
		touristGuideDto.setPhoto(touristGuide.getPhoto());
		touristGuideDto.setContactNumber(touristGuide.getContactNumber());
		touristGuideDto.setAadharNumber(touristGuide.getAadharNumber());
		touristGuideDto.setTour(tour);
		
		
		return touristGuideDto;
		
	}

}
