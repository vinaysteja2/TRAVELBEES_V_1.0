package com.review.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfiguration {
//this is configuration class  for setting up Rbbitmq in springboot
	
	@Bean
	public Queue tourRatingQueue() {
		
		return new Queue("tourRatingQueue");
	}

@Bean
public MessageConverter	jsonMessageConverter() {
	
	return new Jackson2JsonMessageConverter();
	
}

@Bean
public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	
	RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
	rabbitTemplate.setMessageConverter(jsonMessageConverter());
	
	return rabbitTemplate;
}
	
}
