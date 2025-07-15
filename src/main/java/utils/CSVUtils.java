package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CSVUtils {

    public static List<Map<String, String>> readCSV(String filePath) {
        List<Map<String, String>> allData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(",");
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> data = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    data.put(headers[i].trim(), values[i].trim());
                }
                allData.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }
}
