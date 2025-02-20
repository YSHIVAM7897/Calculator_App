package com.example.calculator.util;

import java.util.Stack;

public class Utility {

    // Method to calculate the result of the arithmetic expression
    public static Double calculate(String expression) {
        try {
            return evaluate(expression);
        } catch (Exception e) {
            throw new ArithmeticException("Invalid Expression: " + e.getMessage());
        }
    }

    // Method to evaluate the expression considering parentheses and operator precedence
    private static Double evaluate(String expression) {
        // Removing any spaces from the expression
        expression = expression.replaceAll(" ", "");

        // Stack to store numbers
        Stack<Double> numbers = new Stack<>();

        // Stack to store operators
        Stack<Character> operators = new Stack<>();

        // Variables to store the current number and operator
        StringBuilder number = new StringBuilder();
        boolean lastWasOperator = true;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch);
                lastWasOperator = false;
            } else if (ch == '(') {
                operators.push(ch);
                lastWasOperator = true;
            } else if (ch == ')') {
                if (number.length() > 0) {
                    numbers.push(Double.parseDouble(number.toString()));
                    number.setLength(0);
                }
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(numbers, operators.pop());
                }
                operators.pop();
                lastWasOperator = false;
            } else if (isOperator(ch)) {
                if (number.length() > 0) {
                    numbers.push(Double.parseDouble(number.toString()));
                    number.setLength(0);
                }
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    performOperation(numbers, operators.pop());
                }
                operators.push(ch);
                lastWasOperator = true;
            } else if (ch == '%' && !lastWasOperator) {
                // Handle percentage operation
                if (number.length() > 0) {
                    double value = Double.parseDouble(number.toString());
                    numbers.push(value / 100);
                    number.setLength(0);
                } else if (!numbers.isEmpty()) {
                    double value = numbers.pop();
                    numbers.push(value / 100);
                }
                lastWasOperator = true;
            } else if (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                number.append(ch);
                lastWasOperator = false;
            }
        }

        if (number.length() > 0) {
            numbers.push(Double.parseDouble(number.toString()));
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators.pop());
        }

        return numbers.pop();
    }
 
    private static void performOperation(Stack<Double> numbers, char operator) {
        double b = numbers.pop();
        double a = numbers.isEmpty() ? 0 : numbers.pop(); // Handle single operand situations
        switch (operator) {
            case '+': numbers.push(a + b); break;
            case '-': numbers.push(a - b); break;
            case 'x': numbers.push(a * b); break;
            case '÷':
                if (b == 0) throw new ArithmeticException("Division by zero");
                numbers.push(a / b);
                break;
            case '%': numbers.push(a * (b / 100)); break; // Treat as a percentage of a
        }
    }

    // Helper method to determine operator precedence
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-': return 1;
            case 'x':
            case '÷': return 2;
            case '%': return 3; // Higher precedence for percentage operation
            default: return -1;
        }
    }

    // Helper method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == 'x' || ch == '÷' || ch == '%';
    }
}