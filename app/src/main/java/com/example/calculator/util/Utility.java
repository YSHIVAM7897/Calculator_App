package com.example.calculator.util;

public class Utility {
    private Double result = 0.0;

    // Method to calculate the result of the arithmetic expression
    public static Double calculate(String expression) {
        Utility calculator = new Utility();
        return calculator.calculateExpression(expression);
    }

    // Method to calculate the expression
    public Double calculateExpression(String expression) {
        // Split the expression into parts based on operators (+, -, *, /)
        String[] parts = expression.split("[+\\-x÷]");

        // Split the expression into operators
        String[] operators = expression.split("[0-9.]+");

        // Start with the first number
        result = Double.parseDouble(parts[0]);

        // Iterate through parts and apply corresponding operation
        for (int i = 1; i < parts.length; i++) {
            if (operators[i].equals("÷")) {
                if (Double.parseDouble(parts[i]) != 0) {
                    result /= Double.parseDouble(parts[i]);
                } else {
                    // Handle division by zero error
                    throw new ArithmeticException("Division by zero");
                }
            } else if (operators[i].equals("x")) {
                result *= Double.parseDouble(parts[i]);
            } else if (operators[i].equals("+")) {
                result += Double.parseDouble(parts[i]);
            } else if (operators[i].equals("-")) {
                result -= Double.parseDouble(parts[i]);
            }
        }

        // Print the result
        System.out.println("Result: " + result);

        return result;
    }
}





//public class Utility {
//    public static Double calAdd(String str) {
//        double sum = 0;
//        String[] str2;
//        if (str.contains("+")) {
//            str2 = str.split("\\+");
//            for (String s : str2) {
//                if (!s.isBlank()) {
//                    sum = sum + Double.parseDouble(s);
//                }
//            }
//        } else {
//            if (!str.isBlank())
//                sum = sum + Double.parseDouble(str);
//        }
//        System.out.println(sum);
//        return sum;
//    }
//
//    public static Double callMultiplication(String str) {
//        double mul = 1;
//        String[] str2;
//        if (str.contains("x")) {
//            str2 = str.split("x");
//            for (String s : str2) {
//                if (!s.isBlank()) {
//                    mul = mul * Double.parseDouble(s);
//                }
//            }
//        } else {
//            if (!str.isBlank())
//                mul = mul * Double.parseDouble(str);
//        }
//        System.out.println(mul);
//        return mul;
//    }
//
//}