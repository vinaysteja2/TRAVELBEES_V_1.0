package com.gateway.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfig {
	
	@Bean 
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	 

	
	  @Bean
	    public CorsWebFilter corsWebFilter() {
	        CorsConfiguration corsConfig = new CorsConfiguration();
	        corsConfig.addAllowedOrigin("http://localhost:4200"); // Allow requests from localhost
	        corsConfig.addAllowedOrigin("http://13.200.254.156:4200");
	        corsConfig.addAllowedMethod("*");
	        corsConfig.addAllowedHeader("*");
	        corsConfig.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfig);

	        return new CorsWebFilter(source);
	    }
	
//	@Bean
//	public CorsWebFilter corsWebFilter() {
//	    CorsConfiguration corsConfig = new CorsConfiguration();
//	    corsConfig.addAllowedOrigin("http://localhost:4200");  // Replace with your production frontend domain
//	    corsConfig.addAllowedOrigin("http://frontend:4200");  // In Docker network, frontend uses service name
//	    corsConfig.addAllowedMethod("GET");  // Allow GET method
//	    corsConfig.addAllowedMethod("POST");  // Allow POST method
//	    // Add more methods as needed, e.g., PUT, DELETE, etc.
//	    corsConfig.addAllowedHeader("Content-Type");  // Allow specific headers
//	    corsConfig.addAllowedHeader("Authorization");  // Allow Authorization header
//	    corsConfig.setAllowCredentials(true);  // Allow cookies and credentials
//
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    source.registerCorsConfiguration("/**", corsConfig);
//
//	    return new CorsWebFilter(source);
//	}

	
	

}
