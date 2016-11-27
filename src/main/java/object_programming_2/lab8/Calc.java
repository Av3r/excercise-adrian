package object_programming_2.lab8;

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
        switch (operation) {
            case "+":
                result = add(first, second);
                return String.valueOf(result);
            case "-":
                result = subtract(first, second);
                return String.valueOf(result);
            case "*":
                result = multiply(first, second);
                return String.valueOf(result);
            case "/":
                result = divide(first, second);
                return String.valueOf(result);
            default:
                return "Invalid command to calc";
        }
    }

    private static BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    private BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    private BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }

    private BigDecimal divide(BigDecimal first, BigDecimal second) {
        BigDecimal result = first.divide(second, 7, RoundingMode.HALF_UP);
        return result.stripTrailingZeros();
    }
}
