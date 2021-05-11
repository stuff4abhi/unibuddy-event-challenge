package com.unibuddy.event.utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CsvUtility {

    private final List<CSVRecord> records;

    public CsvUtility(String fileName) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        FileReader reader = new FileReader(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
        records = csvParser.getRecords();
    }

    public String getCellValue(int row, String field){
        String value;
        try {
            value = records.get(row-1).get(field);
        } catch (IllegalArgumentException e){
            value = "";
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        CsvUtility util = new CsvUtility("registrationData.csv");
        System.out.println(util.getCellValue(1,"firstName"));
        System.out.println(util.getCellValue(1,"lastName"));
    }
}
