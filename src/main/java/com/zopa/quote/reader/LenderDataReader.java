package com.zopa.quote.reader;

import com.zopa.quote.constants.SupportedFileTypes;
import com.zopa.quote.model.Lender;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martofrog on 14/06/17.
 */
public class LenderDataReader {

    public static List<Lender> getLenders(String filePath) {
        String fileType = FilenameUtils.getExtension(filePath);

        if (SupportedFileTypes.isValidFileType(fileType)) {
            if (fileType.equals(SupportedFileTypes.CSV)) {
                return CsvDataReader.getLenders(filePath);
            }
        }

        return new ArrayList<Lender>();
    }

}
