package com.springtesting.demo.repository;

import com.springtesting.demo.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Find users by name")
    void testFindByName() {
        userRepository.save(new User(1L, "Sayak"));
        userRepository.save(new User(2L, "Alex"));
        userRepository.save(new User(3L, "Sayak"));

        List<User> sayaks = userRepository.findByName("Sayak");

        assertEquals(2, sayaks.size());
        for (User u : sayaks) {
            assertEquals("Sayak", u.getName());
        }
    }
}
