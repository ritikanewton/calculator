package com.newtonschool.calculator.service;

public class MathService {
    public static double calculate(String operator, Integer operand1, Integer operand2) {
        if (operator.equals("add"))
            return operand1+operand2;
        else if (operator.equals("subtract"))
            return operand1-operand2;
        else if (operator.equals("multiply"))
            return operand1*operand2;
        else if (operator.equals("divide"))
            return operand1/operand2;
        else
            return 0;
    }
}