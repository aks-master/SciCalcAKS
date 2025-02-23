package org.example;
import java.lang.Math;
import java.util.Scanner;

public class Calculator {

    // Method for Square Root
    public double squareRootFunc(int x) {
        return Math.sqrt(x);  // No exception handling for negative numbers
    }

    // Method for Factorial
    public long factorialFunc(int x) {
        long result = 1;
        for (int factor = 2; factor <= x; factor++) {
            result *= factor;
        }
        return result;
    }

    // Method for Natural Logarithm
    public double naturalLogFun(int x) {
        return Math.log(x);  // No exception handling for non-positive numbers
    }

    // Method for Power
    public long powerFunc(int x, int b) {
        return (long) Math.pow(x, b);  // No exception handling for 0^0 or 0^-1
    }

    // Method for Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Method for Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method for Multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method for Division
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not possible.");
            return Double.NaN;  // Return NaN if division by zero is attempted
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Calculator sc = new Calculator();
        boolean exitNow = false;

        while (!exitNow) {
            System.out.println("""
                    Scientific Calculator. Select Operation to be performed:
                    1. Addition
                    2. Subtraction
                    3. Multiplication
                    4. Division
                    5. Evaluate Square Root of the number sqrt(x)
                    6. Evaluate Factorial of the number x!
                    7. Evaluate Natural Log(base e) ln(x)
                    8. Evaluate Power of the number x^b
                    9. Enter any other number >=9 to exit!!
                    """);

            int operation = s.nextInt();
            switch (operation) {
                case (1):
                    System.out.println("Enter two numbers: ");
                    int x1 = s.nextInt();
                    int y1 = s.nextInt();
                    System.out.println("The sum is: " + sc.add(x1, y1));
                    break;
                case (2):
                    System.out.println("Enter two numbers: ");
                    int x2 = s.nextInt();
                    int y2 = s.nextInt();
                    System.out.println("The difference is: " + sc.subtract(x2, y2));
                    break;
                case (3):
                    System.out.println("Enter two numbers: ");
                    int x3 = s.nextInt();
                    int y3 = s.nextInt();
                    System.out.println("The product is: " + sc.multiply(x3, y3));
                    break;
                case (4):
                    System.out.println("Enter two numbers: ");
                    int x4 = s.nextInt();
                    int y4 = s.nextInt();
                    double result = sc.divide(x4, y4);
                    if (!Double.isNaN(result)) {
                        System.out.println("The quotient is: " + result);
                    }
                    break;
                case (5):
                    System.out.println("Enter the number: ");
                    int x5 = s.nextInt();
                    System.out.println("The square root is: " + sc.squareRootFunc(x5));
                    break;
                case (6):
                    System.out.println("Enter the number: ");
                    int x6 = s.nextInt();
                    System.out.println("The factorial is: " + sc.factorialFunc(x6));
                    break;
                case (7):
                    System.out.println("Enter the number: ");
                    int x7 = s.nextInt();
                    System.out.println("The natural logarithm is: " + sc.naturalLogFun(x7));
                    break;
                case (8):
                    System.out.println("Enter the base and the power: ");
                    int x8 = s.nextInt();
                    int y8 = s.nextInt();
                    System.out.println("The power value is: " + sc.powerFunc(x8, y8));
                    break;
                default:
                    exitNow = true;
            }
        }
        s.close();
    }
}
