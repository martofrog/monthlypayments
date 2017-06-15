package com.zopa.quote.util;

import java.math.BigDecimal;

/**
 * Created by martofrog on 14/06/17.
 */
public class ZopaQuoteUtils {

    public static Integer getLoanFromString(String arg) {
        Integer loan;

        try {
            loan = Integer.valueOf(arg);

            if (loan < 1000
                    || loan > 15000
                    || loan % 100 != 0) {
                loan = null;
            }

        }
        catch (NumberFormatException exc) {
            loan = null;
        }

        return loan;
    }

    public static BigDecimal getMonthlyPayment(BigDecimal annualRate, Integer loan, Integer numberOfMonths) {
        BigDecimal M = BigDecimal.ZERO;

        if (annualRate.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("annual rate must be greater then 0.0");
            return M;
        }

        try {
            BigDecimal P = BigDecimal.valueOf(loan.longValue());
            BigDecimal r = annualRate.divide(new BigDecimal(12), 6, BigDecimal.ROUND_DOWN);
            BigDecimal c = r.add(BigDecimal.ONE).pow(numberOfMonths);
            BigDecimal num = c.multiply(r);
            BigDecimal den = c.subtract(BigDecimal.ONE);

            M = P.multiply(num).divide(den, 2, BigDecimal.ROUND_HALF_UP);
        }
        catch (ArithmeticException exc) {
            System.out.println("error evaluating monthly payment");
        }

        return M;
    }
}