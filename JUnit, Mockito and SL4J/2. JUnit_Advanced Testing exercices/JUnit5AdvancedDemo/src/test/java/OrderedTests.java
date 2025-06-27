package test.java;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Running secondTest()");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("Running firstTest()");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Running thirdTest()");
        Assertions.assertTrue(true);
    }
}
