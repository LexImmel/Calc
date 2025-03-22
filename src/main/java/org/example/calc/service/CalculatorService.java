package org.example.calc.service;

import org.example.calc.exceptions.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double plus(Double a, Double b) {
        return a + b;
    }

    public double minus(Double a, Double b) {
        return a - b;
    }

    public double multiply(Double a, Double b) {
        return a * b;
    }

    public double divide(Double a, Double b) {
        if (b == 0) {
            throw new DivideByZeroException("Divide by zero");
        }
        return a / b;
    }
}
