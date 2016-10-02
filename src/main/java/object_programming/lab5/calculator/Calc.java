package object_programming.lab5.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calc {

    public String doCalc(String text) {
        Scanner scanner = new Scanner(text);
        BigDecimal first = scanner.nextBigDecimal();
        String operation = scanner.next();
        BigDecimal second = scanner.nextBigDecimal();
        BigDecimal result;
        switch(operation){
            case "+":
                result = add(first, second);
                return String.valueOf(result);
            case "-":
                result = substract(first,second);
                return String.valueOf(result);
            case "*":
                result= multiply(first,second);
                return String.valueOf(result);
            case "/":
                result= divide(first,second);
                return  String.valueOf(result);
            default:
               return "Invalid command to calc";
        }
    }

    private BigDecimal add(BigDecimal first, BigDecimal second){
        return first.add(second);
    }

    private BigDecimal substract(BigDecimal first, BigDecimal second){
        return first.subtract(second);
    }

    private BigDecimal multiply(BigDecimal first, BigDecimal second){
        return first.multiply(second);
    }

    private BigDecimal divide(BigDecimal first, BigDecimal second){
        BigDecimal result = first.divide(second, 7, RoundingMode.HALF_UP);
        return result.stripTrailingZeros();
    }
}
