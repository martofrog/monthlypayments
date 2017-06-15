package com.zopa.quote.service;

import com.zopa.quote.model.Lender;
import com.zopa.quote.model.Quote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.zopa.quote.util.ZopaQuoteUtils.getMonthlyPayment;

/**
 * Created by martofrog on 14/06/17.
 */
public class BestQuoteService {

    public static Quote getBestQuote(List<Lender> lenderList, Integer loan) {

        List<Lender> filteredLenderList = filterLenders(lenderList, loan);

        if (filteredLenderList.isEmpty()) {
            System.out.println("cannot find valid lender");
            return null;
        }

        Collections.sort(filteredLenderList);
        Lender bestLender = filteredLenderList.get(0);

        BigDecimal monthlyPayment = getMonthlyPayment(bestLender.getRate(), loan, 36);
        if (monthlyPayment.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("could not evaluate monthly payment");
            return null;
        }

        BigDecimal totalPayment = monthlyPayment.multiply(new BigDecimal(36))
                .setScale(2, BigDecimal.ROUND_HALF_UP);

        Quote quote = new Quote();
        quote.setMonthlyRepayment(monthlyPayment.toString());
        quote.setTotRepayment(totalPayment.toString());
        quote.setRequestedAmount(String.valueOf(loan));
        quote.setRate(bestLender.getRate().multiply(new BigDecimal(100))
                .setScale(1, BigDecimal.ROUND_DOWN).toString());

        return quote;
    }

    private static List<Lender> filterLenders(List<Lender> lenderList, Integer loan) {
        List<Lender> filteredLenderList = new ArrayList<Lender>();
        for (Lender lender : lenderList) {
            if (lender
                    .getAvailable()
                    .compareTo(loan) >=0) {

                filteredLenderList.add(lender);
            }
        }

        return filteredLenderList;
    }

}
