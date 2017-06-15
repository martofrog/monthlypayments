import com.zopa.quote.Main;
import com.zopa.quote.model.Lender;
import com.zopa.quote.reader.LenderDataReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by martofrog on 14/06/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(LenderDataReader.class)
public class MainTest {

    @Test
    public void testNoArgs() {
        PowerMockito.mockStatic(LenderDataReader.class);

        Main.main(null);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testEmptyArgs() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"", ""};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testOneArg() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"", ""};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testNegativeLoan() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "-10"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testLoanTooLow() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "300"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testLoanOneThousand() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "1000"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(1));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testLoan15Thousand() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "15000"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(1));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testValidLoan() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "1200"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(1));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testInvalidLoan() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "1250"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testLoanTooHigh() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "150000"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testInvalidLoanLiteral() {
        PowerMockito.mockStatic(LenderDataReader.class);

        String[] args = {"test.csv", "AAAA"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(0));
        LenderDataReader.getLenders(anyString());
    }

    @Test
    public void testCorrectInput() {
        PowerMockito.mockStatic(LenderDataReader.class);
        when(LenderDataReader.getLenders(anyString()))
                .thenReturn(new ArrayList<Lender>());

        String[] args = {"test.csv", "1500"};
        Main.main(args);

        PowerMockito.verifyStatic(Mockito.times(1));
        LenderDataReader.getLenders(anyString());
    }

}
