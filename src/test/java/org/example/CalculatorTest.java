package org.example;
 /*
 STUDENT NUMBER : B201202046
 NAME : BEKİRCAN
 SURNAME : KÜÇÜKAKIN
 CLASS : SOFTWARE VERIFICATION AND VALIDATION - HW1
  */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
cd
class CalculatorTest {

    @ParameterizedTest
    @MethodSource("divisionTestData")
    void testDivision(float dividend, float divisor, float expectedResult) {
        assertEquals(expectedResult, Calculator.divide(dividend, divisor));
    }

    private static Stream<Arguments> divisionTestData() {
        return Stream.of(
                Arguments.of(10, 2, 5),      // testDivision1
                Arguments.of(10, 4, 2.5f),    // testDivision2
                Arguments.of(12.5f, 2.5f, 5),// testDivision3
                Arguments.of(10, 2.5f, 4),   // testDivision4
                Arguments.of(12.5f, 5, 2.5f) // testDivision5
        );
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "Dividing by zero should throw IllegalArgumentException."
        );

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}