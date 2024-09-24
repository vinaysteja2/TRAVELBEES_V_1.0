package com.user.dto;

public class AuthResponse {
	
	private String token;
	
	private String role;
	
	private long Id;

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token, String role, long id) {
		super();
		this.token = token;
		this.role = role;
		Id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "AuthResponse [token=" + token + ", role=" + role + ", Id=" + Id + "]";
	}


	
	

}
