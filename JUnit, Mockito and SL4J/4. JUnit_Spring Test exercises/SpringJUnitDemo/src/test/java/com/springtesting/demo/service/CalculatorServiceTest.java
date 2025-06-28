package com.springtesting.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 7);
        assertEquals(12, result);
    }
}
