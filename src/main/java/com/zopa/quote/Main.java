package com.zopa.quote;

import com.zopa.quote.model.Lender;
import com.zopa.quote.model.Quote;
import com.zopa.quote.reader.LenderDataReader;
import com.zopa.quote.service.BestQuoteService;

import java.util.List;

import static com.zopa.quote.util.ZopaQuoteUtils.getLoanFromString;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by martofrog on 13/06/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(">> Welcome to Zopa Quote << \n");

        if (args == null
                || args.length < 2
                || isBlank(args[0])
                || isBlank(args[1])) {
            System.out.println("please provide correct arguments: i.e. ./lenders_data.csv 1500");
            return;
        }

        String filePath = args[0];
        Integer loan = getLoanFromString(args[1]);

        if (loan == null) {
            System.out.println("please provide correct value for loan: it should be any £100 increment between £1000 and £15000 inclusive");
            return;
        }

        List<Lender> lenderList = LenderDataReader.getLenders(filePath);
        if (lenderList.isEmpty()) {
            System.out.println("data provided didn't contain any valid lender");
            return;
        }

        Quote quote = BestQuoteService.getBestQuote(lenderList, loan);

        if (quote == null) {
            System.out.println("sorry it hasn't been possible to find an offer at this time");
        }
        else {
            System.out.println("Requested amount: £" + quote.getRequestedAmount());
            System.out.println("Rate: " + quote.getRate() + "%");
            System.out.println("Monthly repayment: £" + quote.getMonthlyRepayment());
            System.out.println("Total repayment: £" + quote.getTotRepayment());
        }

    }



}
