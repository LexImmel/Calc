package org.example.calc;

import org.example.calc.exceptions.DivideByZeroException;
import org.example.calc.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorService calcService = new CalculatorService();

    @Test
    public void testPlus() {
        assertEquals(10, calcService.plus(4.0,6.0));
        assertEquals(-2, calcService.plus(-8.0,6.0));
    }
    @Test
    public void testMinus() {
        assertEquals(4, calcService.minus(20.0,16.0));
        assertEquals(-2, calcService.minus(6.0,8.0));
    }
    @Test
    public void testMultiply() {
        assertEquals(10, calcService.multiply(2.0,5.0));
        assertEquals(-20, calcService.multiply(-2.0,10.0));
    }
    @Test
    public void testDivide() {
        assertEquals(10, calcService.divide(60.0,6.0));
        assertEquals(-2, calcService.divide(-8.0,4.0));
    }
    @Test
    public void divideByZero() {
        Exception exception = assertThrows(DivideByZeroException.class, () -> {
            calcService.divide(2.0,0.0);
        });
        assertEquals("Divide by zero", exception.getMessage());
    }
}
