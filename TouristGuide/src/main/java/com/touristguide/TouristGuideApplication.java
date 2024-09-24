package com.touristguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TouristGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristGuideApplication.class, args);
	}

}
