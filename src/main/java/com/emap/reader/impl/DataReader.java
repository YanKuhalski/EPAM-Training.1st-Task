package com.emap.reader.impl;

import com.emap.reader.Reader;
import com.emap.exeptions.DataExeption;
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
            dataExeption.printStackTrace();
            log.error(dataExeption);
            return null;
        }
    }

    private List<String> read(String path) throws DataExeption {
        try (FileInputStream fstream = new FileInputStream(path)) {
            List<String> strings = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                strings.add(strLine);
            }
            br.close();
            log.info("Data was successfully read");
            return strings;
        } catch (IOException e) {
            throw new DataExeption("Problem with file reading", e);
        }
    }
}
