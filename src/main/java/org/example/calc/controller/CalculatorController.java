package org.example.calc.controller;

import org.example.calc.exceptions.DivideByZeroException;
import org.example.calc.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Calculator!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        double result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateParameters(num1, num2);
        if (num2 == 0) {
            throw new DivideByZeroException("You can not divide by zero!");
        } else {
            double result = calculatorService.divide(num1, num2);
            return num1 + "/" + num2 + " = " + result;
        }
    }

    private void validateParameters(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Both parameters must be non-null!");
        }
    }
}
