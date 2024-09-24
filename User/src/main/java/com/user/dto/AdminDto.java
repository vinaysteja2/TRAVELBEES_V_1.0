package com.user.dto;


import com.user.entity.UserRole;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminDto {
	    
	    
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
 
		public AdminDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AdminDto( String username,String password,String email,String mobileNo,UserRole role) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.mobileNo = mobileNo;
			this.role=role;
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

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		   public UserRole getRole() {
		        return role;
		    }

		    public void setRole(UserRole role) {
		        this.role = role;
		    }
	    
	    
}
