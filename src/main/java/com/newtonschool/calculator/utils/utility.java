package com.newtonschool.calculator.utils;

import com.newtonschool.calculator.constants.CalculatorConstants;

public class utility {

    public static String getSymbol(String operator){
        if(operator.equalsIgnoreCase("add"))
            return "+";
        else if(operator.equalsIgnoreCase("subtract"))
            return "-";
        else if(operator.equalsIgnoreCase("multiply"))
            return "*";
        else if(operator.equalsIgnoreCase("divide"))
            return "/";
        else
            return CalculatorConstants.NOT_SUPPORTED_OPERATION;
    }
}
