package com.zopa.quote.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by martofrog on 14/06/17.
 */
public class SupportedFileTypes {

    public static String CSV = "csv";

    private static Set<String> fileTypes = new HashSet<String>(Arrays.asList(CSV));

    public static Boolean isValidFileType(String fileType) {
       return fileTypes.contains(fileType);
    }

}
