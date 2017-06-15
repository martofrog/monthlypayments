package reader;

import com.zopa.quote.model.Lender;
import com.zopa.quote.reader.CsvDataReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by martofrog on 14/06/17.
 */
public class CsvDataReaderTest {

    @Test
    public void testInvalidFilePath() {
        List<Lender> lenders = CsvDataReader.getLenders("");
        assertEquals(0, lenders.size());
    }

    @Test
    public void testNullFilePath() {
        List<Lender> lenders = CsvDataReader.getLenders(null);
        assertEquals(0, lenders.size());
    }

    @Test
    public void testCorrectFilePath() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/lenders_1.csv");
        assertEquals(7, lenders.size());

        assertEquals("Bob", lenders.get(0).getLenderName());
        assertEquals(BigDecimal.valueOf(0.075), lenders.get(0).getRate());
        assertEquals(Integer.valueOf(640), lenders.get(0).getAvailable());

        assertEquals("Angela", lenders.get(6).getLenderName());
        assertEquals(BigDecimal.valueOf(0.071), lenders.get(6).getRate());
        assertEquals(Integer.valueOf(60), lenders.get(6).getAvailable());
    }

    @Test
    public void testIncorrectFileFormat() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/invalid_lenders_1.csv");
        assertEquals(0, lenders.size());
    }

    @Test
    public void testIncorrectFileContent() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/invalid_lenders_2.csv");
        assertEquals(4, lenders.size());
    }

    @Test
    public void testEmptyFile() {
        List<Lender> lenders = CsvDataReader.getLenders("src/test/resources/invalid_lenders_3.csv");
        assertEquals(0, lenders.size());
    }
}
