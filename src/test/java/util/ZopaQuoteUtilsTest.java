package util;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zopa.quote.util.ZopaQuoteUtils.getMonthlyPayment;
import static org.junit.Assert.assertEquals;

/**
 * Created by martofrog on 15/06/17.
 */
public class ZopaQuoteUtilsTest {

    @Test
    public void testGetMonthlyPaymentZeroAnnualRate() {
        BigDecimal M = getMonthlyPayment(BigDecimal.valueOf(0.0), 1500, 0);
        assertEquals(BigDecimal.ZERO, M);
    }

    @Test
    public void testGetMonthlyPaymentNegativeAnnualRate() {
        BigDecimal M = getMonthlyPayment(BigDecimal.valueOf(-1), 1500, 0);
        assertEquals(BigDecimal.ZERO, M);
    }

    @Test
    public void testGetMonthlyPayment1() {
        BigDecimal M = getMonthlyPayment(BigDecimal.valueOf(0.070), 1000, 36);
        assertEquals(BigDecimal.valueOf(30.88), M);
    }

    @Test
    public void testGetMonthlyPayment2() {
        BigDecimal M = getMonthlyPayment(BigDecimal.valueOf(0.104), 15000, 36);
        assertEquals(BigDecimal.valueOf(486.82), M);
    }

}
