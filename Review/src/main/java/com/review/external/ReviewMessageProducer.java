package com.review.external;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.review.entity.Review;

@Service
public class ReviewMessageProducer {
	
	private final RabbitTemplate rabbitTemplate;

	public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	public void sendMessage(Review review) {
		
		ReviewMessage reviewMessage=new ReviewMessage();
		
		reviewMessage.setId(review.getId());
		reviewMessage.setComment(review.getComment());
		reviewMessage.setRating(review.getRating());
		reviewMessage.setTourId(review.getTourId());
		reviewMessage.setTouristGuideId(review.getTouristGuideId());
		reviewMessage.setUserId(review.getUserId());
		
		rabbitTemplate.convertAndSend("tourRatingQueue",reviewMessage);
		
	}
	

}
