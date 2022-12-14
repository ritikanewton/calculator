package com.newtonschool.calculator.controllers;

import com.newtonschool.calculator.exception.CalcException;
import com.newtonschool.calculator.service.Answer;
import com.newtonschool.calculator.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.newtonschool.calculator.constants.CalculatorConstants.NOT_SUPPORTED_OPERATION;
import static com.newtonschool.calculator.utils.utility.getSymbol;

@RestController
public class CalculatorController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Calculator App";
    }

    private final AtomicLong counter = new AtomicLong();

    @PostMapping(value = "/calculate",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Answer> sample(@RequestParam(value = "operator", required = true, defaultValue = "") String operator,
                         @RequestParam Integer operand1,
                         @RequestParam Integer operand2){
        try {
            long resultId = counter.incrementAndGet();
            String symbol = getSymbol(operator);
            if(symbol.equalsIgnoreCase(NOT_SUPPORTED_OPERATION))
                throw new CalcException(NOT_SUPPORTED_OPERATION);
            String expr = String.valueOf(operand1) + getSymbol(operator) + String.valueOf(operand2);
            double result = MathService.calculate(operator, operand1, operand2);
            Answer answer = new Answer(resultId, result, expr);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }catch (Exception ex) {
            System.out.print(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
