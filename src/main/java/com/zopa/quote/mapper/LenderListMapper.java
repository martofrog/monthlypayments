package com.zopa.quote.mapper;

import com.zopa.quote.model.Lender;
import org.apache.commons.csv.CSVRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by martofrog on 14/06/17.
 */
public class LenderListMapper {

    public static List<Lender> map(Iterable<CSVRecord> records) {
        List<Lender> lenderList = new ArrayList<Lender>();
        for (CSVRecord record : records) {
            try {
                String lenderName = record.get(0).trim();
                BigDecimal rate = new BigDecimal(record.get(1).trim());
                Integer available = Integer.valueOf(record.get(2).trim());

                Lender lander = new Lender();
                lander.setLenderName(lenderName);
                lander.setRate(rate);
                lander.setAvailable(available);

                lenderList.add(lander);
            }
            catch (Exception exc) {
                System.out.println("invalid csv input: " + exc.getMessage());
            }
        }

        return lenderList;
    }

}
