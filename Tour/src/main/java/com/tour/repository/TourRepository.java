package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

	List<Tour> findByTouristGuideId(Long touristGuideId);

	void deleteByTouristGuideId(Long touristGuideId);
	 public void deleteTourByTouristGuideId(Long touristGuideId);
	 
	public boolean existsByTouristGuideId(Long touristGuideId);
}
