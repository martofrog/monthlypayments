package reader;

import com.zopa.quote.model.Lender;
import com.zopa.quote.reader.CsvDataReader;
import com.zopa.quote.reader.LenderDataReader;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by martofrog on 14/06/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CsvDataReader.class)
public class LenderDataReaderTest {

    @Test
    public void testNullFilepath() {
        PowerMockito.mockStatic(CsvDataReader.class);

        List<Lender> lenders = LenderDataReader.getLenders(null);

        PowerMockito.verifyStatic(Mockito.times(0));
        CsvDataReader.getLenders(anyString());
        assertEquals(0, lenders.size());
    }

    @Test
    public void testJsonFile() {
        PowerMockito.mockStatic(CsvDataReader.class);

        List<Lender> lenders = LenderDataReader.getLenders("lenders.json");

        PowerMockito.verifyStatic(Mockito.times(0));
        CsvDataReader.getLenders(anyString());
        assertEquals(0, lenders.size());
    }

    @Test
    public void testValidCsv() {
        PowerMockito.mockStatic(CsvDataReader.class);
        ArrayList<Lender> lendersMock = new ArrayList<Lender>();
        lendersMock.add(new Lender("lender1", BigDecimal.valueOf(0.07), 100));
        lendersMock.add(new Lender("lender2", BigDecimal.valueOf(0.05), 200));

        when(CsvDataReader.getLenders(anyString()))
                .thenReturn(lendersMock);

        List<Lender> lenders = LenderDataReader.getLenders("lenders.csv");

        PowerMockito.verifyStatic(Mockito.times(1));
        CsvDataReader.getLenders(anyString());
        Assert.assertEquals(2, lenders.size());
    }

}
