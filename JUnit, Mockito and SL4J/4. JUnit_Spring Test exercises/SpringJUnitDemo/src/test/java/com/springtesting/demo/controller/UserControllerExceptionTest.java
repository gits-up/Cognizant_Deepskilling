package com.springtesting.demo.controller;

import com.springtesting.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(UserController.class)
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testUserNotFoundExceptionHandling() throws Exception {
        Long invalidId = 999L;

        Mockito.when(userService.getUserById(invalidId)).thenThrow(new NoSuchElementException("User not found"));

        mockMvc.perform(get("/users/" + invalidId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
