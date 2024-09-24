package com.tour.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.tour.dto.ReviewMessage;
import com.tour.entity.Tour;
import com.tour.serviceimpl.TourServiceImpl;

@Service
public class ReviewMessageConsumer {
	
	private final TourServiceImpl tour;

	public ReviewMessageConsumer(TourServiceImpl tour) {
		super();
		this.tour = tour;
	}
	
	@RabbitListener(queues="tourRatingQueue")
	public void consumeMessage(ReviewMessage reviewMessage) {
		
	
		
		tour.updateTourRating(reviewMessage );
		
		
		
	}
	

}
