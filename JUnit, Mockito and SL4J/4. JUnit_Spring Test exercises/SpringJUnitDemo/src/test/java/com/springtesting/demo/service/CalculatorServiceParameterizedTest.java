package com.springtesting.demo.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "-1, 5, 4",
        "0, 0, 0",
        "100, 200, 300",
        "-10, -5, -15"
    })
    void testAdd(int a, int b, int expectedSum) {
        assertEquals(expectedSum, calculatorService.add(a, b),
                () -> "Expected " + expectedSum + " but got " + calculatorService.add(a, b));
    }
}
