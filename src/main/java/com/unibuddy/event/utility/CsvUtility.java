package com.unibuddy.event.utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvUtility {

    public void CsvUtility(String path) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        FileReader reader = new FileReader(classLoader.getResource(path).getPath());
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());


    }
}
