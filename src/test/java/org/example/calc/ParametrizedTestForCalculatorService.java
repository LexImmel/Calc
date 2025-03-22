package org.example.calc;

import org.example.calc.exceptions.DivideByZeroException;
import org.example.calc.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTestForCalculatorService {
    private final CalculatorService calculatorService = new CalculatorService();

    static Stream<org.junit.jupiter.params.provider.Arguments> plusData() {
        return Stream.of(
                Arguments.of(2.0, 10.0, 12.0),
                Arguments.of(20.0, 5.0, 25.0),
                Arguments.of(100.0, 0.0, 100.0));
    }

    @ParameterizedTest
    @MethodSource("plusData")
    public void testPlus(Double a, double b, double expected) {
        assertEquals(expected, calculatorService.plus(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> minusData() {
        return Stream.of(
                Arguments.of(2.0, 10.0, -8.0),
                Arguments.of(20.0, 5.0, 15.0),
                Arguments.of(100.0, 0.0, 100.0));
    }

    @ParameterizedTest
    @MethodSource("minusData")
    public void testSubtract(Double a, double b, double expected) {
        assertEquals(expected, calculatorService.minus(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> multiplyData() {
        return Stream.of(
                Arguments.of(2.0, 10.0, 20.0),
                Arguments.of(20.0, 5.0, 100.0),
                Arguments.of(100.0, 0.0, 0.0));
    }

    @ParameterizedTest
    @MethodSource("multiplyData")
    public void testMultiply(Double a, double b, double expected) {
        assertEquals(expected, calculatorService.multiply(a, b));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> divideData() {
        return Stream.of(
                Arguments.of(20.0, 10.0, 2.0),
                Arguments.of(40.0, 5.0, 8.0),
                Arguments.of(100.0, 20.0, 5));

    }

    @ParameterizedTest
    @MethodSource("divideData")
    public void testDivide(Double a, double b, double expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }
}
