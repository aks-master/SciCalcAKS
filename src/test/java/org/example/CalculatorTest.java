package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    // Test for square root function
    @Test
    public void testSquareRootFunc() {
        assertEquals(121.0, calculator.squareRootFunc(11), 0.0001); // sqrt(16) = 4
        assertEquals(0.0, calculator.squareRootFunc(0), 0.0001);  // sqrt(0) = 0
    }

    // Test for factorial function
    @Test
    public void testFactorialFunc() {
        assertEquals(1, calculator.factorialFunc(0));    // 0! = 1
        assertEquals(120, calculator.factorialFunc(5));  // 5! = 120
        assertEquals(720, calculator.factorialFunc(6));  // 6! = 720
    }

    // Test for natural log function
    @Test
    public void testNaturalLogFun() {
        assertEquals(Math.log(20), calculator.naturalLogFun(20), 0.0001);  // ln(2) = Math.log(2)
        assertEquals(Math.log(100), calculator.naturalLogFun(100), 0.0001); // ln(10) = Math.log(10)
    }

    // Test for power function
    @Test
    public void testPowerFunc() {
        assertEquals(16, calculator.powerFunc(2, 4));   // 2^3 = 8
        assertEquals(1, calculator.powerFunc(2, 0));   // 2^0 = 1
        assertEquals(1, calculator.powerFunc(0, 0));   // 0^0 = 1 (Java handles this as 1)
        assertEquals(0, calculator.powerFunc(0, 5));   // 0^5 = 0
    }

    // Test for addition function
    @Test
    public void testAdd() {
        assertEquals(8, calculator.add(5, 3));  // 5 + 3 = 8
        assertEquals(0, calculator.add(0, 0));  // 0 + 0 = 0
        assertEquals(-1, calculator.add(5, -6)); // 5 + (-6) = -1
    }

    // Test for subtraction function
    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));  // 5 - 3 = 2
        assertEquals(0, calculator.subtract(5, 5));  // 5 - 5 = 0
        assertEquals(11, calculator.subtract(5, -6)); // 5 - (-6) = 11
    }

    // Test for multiplication function
    @Test
    public void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));   // 5 * 3 = 15
        assertEquals(0, calculator.multiply(5, 0));    // 5 * 0 = 0
        assertEquals(-30, calculator.multiply(-5, 6)); // -5 * 6 = -30
    }

    // Test for division function
    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);  // 6 / 3 = 2
        assertEquals(5.0, calculator.divide(10, 2), 0.0001); // 10 / 2 = 5
        assertTrue(Double.isNaN(calculator.divide(5, 0)));    // 5 / 0 should return NaN
    }
}
