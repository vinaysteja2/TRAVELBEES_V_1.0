package com.gateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	public static final List<String> openApiEndPoints = List.of("/auth/register", "/auth/token", "/eureka","/auth/AdminRegister",
			"/auth/send-otp","/auth/validate-otp","/bookings","/tourist-guides/**","/tours/**");
//	,"/tourist-guides/locations",
//	"/tours","/bookings","/payments","/reviews"

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndPoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));
}

