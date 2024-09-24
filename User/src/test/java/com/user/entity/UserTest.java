package com.user.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserTest {

	 @Test
	    void testNoArgsConstructor() {
	        User user = new User();
	        assertNotNull(user);
	    }

	    @Test
	    void testAllArgsConstructor() {
	        Long id = 1L;
	        String username = "testUser";
	        String password = "testPassword";
	        String email = "test@example.com";
	        String mobileNo = "1234567890";
	        UserRole role = UserRole.USER;

	        User user = new User(id, username, password, email, mobileNo, role);

	        assertEquals(id, user.getId());
	        assertEquals(username, user.getUsername());
	        assertEquals(password, user.getPassword());
	        assertEquals(email, user.getEmail());
	        assertEquals(mobileNo, user.getMobileNo());
	        assertEquals(role, user.getRole());
	    }

	    @Test
	    void testGettersAndSetters() {
	        User user = new User();

	        Long id = 1L;
	        String username = "testUser";
	        String password = "testPassword";
	        String email = "test@example.com";
	        String mobileNo = "1234567890";
	        UserRole role = UserRole.USER;

	        user.setId(id);
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setEmail(email);
	        user.setMobileNo(mobileNo);
	        user.setRole(role);

	        assertEquals(id, user.getId());
	        assertEquals(username, user.getUsername());
	        assertEquals(password, user.getPassword());
	        assertEquals(email, user.getEmail());
	        assertEquals(mobileNo, user.getMobileNo());
	        assertEquals(role, user.getRole());
	    }

	    @Test
	    void testToString() {
	        Long id = 1L;
	        String username = "testUser";
	        String password = "testPassword";
	        String email = "test@example.com";
	        String mobileNo = "1234567890";
	        UserRole role = UserRole.USER;

	        User user = new User(id, username, password, email, mobileNo, role);

	        String expectedToString = "User [id=" + id + ", username=" + username + ", password=" + password + ", email="
	                + email + ", mobileNo=" + mobileNo + ", role=" + role + "]";

	        assertEquals(expectedToString, user.toString());
	    }
}
