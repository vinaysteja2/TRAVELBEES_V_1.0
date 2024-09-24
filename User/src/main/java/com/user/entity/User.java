package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

    @Entity
	@Table(name = "users1")
	public class User {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    
	    @NotNull(message = "Username cannot be null")
	    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	    private String username;

	    @NotNull(message = "Password cannot be null")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	    private String password;

	    @NotNull(message = "Email cannot be null")
	    @Email(message = "Email should be valid")
	    private String email;

//	    @NotNull(message = "Mobile number cannot be null")
//	    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	    private String mobileNo;

	    @Enumerated(EnumType.STRING)
	    @NotNull(message = "Role cannot be null")
	    private UserRole role;

	    
	    public User() {
	        // Default constructor
	    }

	    // Getters and setters for all attributes
	    
	  
	   
	    public Long getId() {
	        return id;
	    }

		public User(Long id, String username, String password, String email, String mobileNo, UserRole role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.mobileNo = mobileNo;
			this.role = role;
		}

		public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public UserRole getRole() {
	        return role;
	    }

	    public void setRole(UserRole role) {
	        this.role = role;
	    }

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", mobileNo=" + mobileNo + ", role=" + role + "]";
		}

		

	}

