package service;

import com.zopa.quote.model.Lender;
import com.zopa.quote.model.Quote;
import com.zopa.quote.reader.CsvDataReader;
import com.zopa.quote.service.BestQuoteService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by martofrog on 15/06/17.
 */
public class BestQuoteServiceTest {

    @Test
    public void testGetBestQuoteLoanTooHigh() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/lenders_1.csv");
        Quote quote = BestQuoteService.getBestQuote(lenders, 1000);

        assertNull(quote);
    }

    @Test
    public void testGetBestQuote1() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/lenders_2.csv");
        Quote quote = BestQuoteService.getBestQuote(lenders, 1000);
        assertEquals("1000", quote.getRequestedAmount());
        assertEquals("7.5", quote.getRate());
        assertEquals("31.11", quote.getMonthlyRepayment());
        assertEquals("1119.96", quote.getTotRepayment());
    }

    @Test
    public void testGetBestQuote2() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/lenders_2.csv");
        Quote quote = BestQuoteService.getBestQuote(lenders, 5100);
        assertEquals("5100", quote.getRequestedAmount());
        assertEquals("8.7", quote.getRate());
        assertEquals("161.47", quote.getMonthlyRepayment());
        assertEquals("5812.92", quote.getTotRepayment());
    }

}
