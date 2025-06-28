package com.springtesting.demo.integration;

import com.springtesting.demo.entity.User;
import com.springtesting.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFullFlow_createAndFetchUser() {
        User user = new User(1L, "Sayak");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<User> postResponse = restTemplate.postForEntity("/users", request, User.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals("Sayak", postResponse.getBody().getName());

        ResponseEntity<User> getResponse = restTemplate.getForEntity("/users/1", User.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals("Sayak", getResponse.getBody().getName());
    }
}
