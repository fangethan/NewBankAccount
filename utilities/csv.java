package com.company.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class csv {
    // this method will read data from a csv file and return as a list
    public static List<String[]> read(String file){
//        List<String[]> data = new List<String[]>();
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read file");
            e.printStackTrace();
        }


        return data;
    }
}
