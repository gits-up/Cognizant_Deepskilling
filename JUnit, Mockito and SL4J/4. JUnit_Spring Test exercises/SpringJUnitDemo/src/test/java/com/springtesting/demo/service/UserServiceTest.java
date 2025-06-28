package com.springtesting.demo.service;

import com.springtesting.demo.entity.User;
import com.springtesting.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById_userNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(100L)).thenReturn(Optional.empty());

        UserService service = new UserService();
        try {
            var field = UserService.class.getDeclaredField("userRepository");
            field.setAccessible(true);
            field.set(service, mockRepo);
        } catch (Exception e) {
            fail("Reflection injection failed");
        }

        User result = service.getUserById(100L);

        assertNull(result);
        verify(mockRepo).findById(100L);
    }
}
