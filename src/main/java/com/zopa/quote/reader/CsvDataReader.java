package com.zopa.quote.reader;

import com.zopa.quote.mapper.LenderListMapper;
import com.zopa.quote.model.Lender;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by martofrog on 14/06/17.
 */
public class CsvDataReader {

    public static List<Lender> getLenders(String filePath) {
        Reader in;

        try {
            in = new FileReader(filePath);
        }
        catch (FileNotFoundException exc) {
            System.out.println("file not found");
            return new ArrayList<Lender>();
        }
        catch (Exception exc) {
            System.out.println("exception: " + exc.getMessage());
            return new ArrayList<Lender>();
        }

        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        List<Lender> lenderList = LenderListMapper.map(records);

        return lenderList;
    }

}
