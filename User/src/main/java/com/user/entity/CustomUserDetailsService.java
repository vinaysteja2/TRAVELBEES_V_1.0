package com.user.entity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.user.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userCredentialRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> credential =  userCredentialRepository.findByUsername(username);
		
		UserDetails userdetails = credential.map(userCredential->new CustomUserDetails(userCredential)).orElseThrow(()->new UsernameNotFoundException("Username for the given name "+username+" is not found"));
		
		return userdetails;
	}

}

