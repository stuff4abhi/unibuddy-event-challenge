package com.unibuddy.event.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class csvUtility {

    public void csvReader() throws IOException,
            CsvValidationException {

        String fileName = "src/test/resources/registrationData.csv";

        try (FileReader fr = new FileReader(fileName);
             CSVReader reader = new CSVReader(fr)) {

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {

                for (String e : nextLine) {
                    System.out.format("%s ", e);
                }
            }
        }
    }

}
