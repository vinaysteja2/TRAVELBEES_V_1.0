package com.user.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.user.entity.User;
import com.user.entity.UserRole;
import com.user.serviceimpl.UserServiceImpl;

class UserRepositoryTest {

	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUsername() {
        String username = "testUser";
        User user = new User(1L, username, "testPassword", "test@example.com", "1234567890", UserRole.USER);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userRepository.findByUsername(username);

        assertTrue(foundUser.isPresent());
        assertEquals(username, foundUser.get().getUsername());

        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void testExistsByUsername() {
        String username = "testUser";

        when(userRepository.existsByUsername(username)).thenReturn(true);

        boolean exists = userRepository.existsByUsername(username);

        assertTrue(exists);

        verify(userRepository, times(1)).existsByUsername(username);
    }

    @Test
    void testExistsByEmail() {
        String email = "test@example.com";

        when(userRepository.existsByEmail(email)).thenReturn(true);

        boolean exists = userRepository.existsByEmail(email);

        assertTrue(exists);

        verify(userRepository, times(1)).existsByEmail(email);
    }

    @Test
    void testSaveUser() {
        User user = new User(1L, "testUser", "testPassword", "test@example.com", "1234567890", UserRole.USER);

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertEquals(user.getUsername(), savedUser.getUsername());

        verify(userRepository, times(1)).save(user);
    }
}
