package com.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

 List<Review> findByTourId(long tourId);
	
	List<Review> findByTouristGuideId(long touristGuideId);
	
	boolean existsByTourId(Long tourId);
	boolean existsByTouristGuideId(Long touristGuideId);
}
