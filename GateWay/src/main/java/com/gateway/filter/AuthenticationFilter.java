package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.gateway.util.JwtUtil;




@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	@Autowired
	private RouteValidator validator;
	
	@Autowired
	JwtUtil jwtUtil;

	public AuthenticationFilter() {
		super(Config.class);
	}

	public static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		//the current server exchange
		//provides a way to delegate to the next filter


		return ((exchange,chain)->{
			if(validator.isSecured.test(exchange.getRequest())) {
				//header contains token or not
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader !=null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try {
					jwtUtil.validateToken(authHeader);
					
				}catch (Exception e) {
					throw new RuntimeException("Unauthorized access to application");
				}
				
			}
			return chain.filter(exchange);
		});
	}
}
///
/*----------ROLES BASED -----------*/
//package com.gateway.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import com.gateway.util.JwtUtil;
//import io.jsonwebtoken.Claims;
//
//import java.util.List;
//
//@Component
//public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
//
//    @Autowired
//    private RouteValidator validator;
//
//    @Autowired
//    JwtUtil jwtUtil;
//
//    public AuthenticationFilter() {
//        super(Config.class);
//    }
//
//    public static class Config {
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            if (validator.isSecured.test(exchange.getRequest())) {
//                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                    throw new RuntimeException("missing authorization header");
//                }
//                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//                if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                    authHeader = authHeader.substring(7);
//                }
//                try {
//                    jwtUtil.validateToken(authHeader);
//                    Claims claims = jwtUtil.getClaims(authHeader);
//                    List<String> roles = claims.get("roles", List.class);
//                    if (!hasRequiredRole(exchange.getRequest(), roles)) {
//                        throw new RuntimeException("Unauthorized access to application");
//                    }
//                } catch (Exception e) {
//                    throw new RuntimeException("Unauthorized access to application", e);
//                }
//            }
//            return chain.filter(exchange);
//        };
//    }
//
//    private boolean hasRequiredRole(ServerHttpRequest request, List<String> roles) {
//        if (validator.isAdmin.test(request) && roles.contains("ROLE_ADMIN")) {
//            return true;
//        } else if (validator.isUser.test(request) && roles.contains("ROLE_USER")) {
//            return true;
//        }
//        return false;
//    }
//}
