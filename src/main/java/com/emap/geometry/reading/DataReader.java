package com.emap.geometry.reading;

import com.emap.geometry.exeptions.DataExeption;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader implements Reader {
    private static final Logger log = Logger.getLogger(DataReader.class);

    @Override
    public List<String> readStrings(String path) {
        try {
            return read(path);
        } catch (DataExeption dataExeption) {
            log.error(dataExeption);
            return new ArrayList<>();
        }
    }

    private List<String> read(String path) throws DataExeption {
        try (FileInputStream fstream = new FileInputStream(path)) {
            List<String> strings = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    strings.add(strLine);
                }
            }
            log.info("Data was successfully read");
            return strings;
        } catch (IOException e) {
            throw new DataExeption("Problem with file reading", e);
        }
    }
}
