package org.example.service;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileService {

    public static List<String> loadScvData(String resoursePath) {
        List<String> data = new LinkedList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(resoursePath))) {
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void generateFile(List<String> data, String resultPath) {
        File file = new File(resultPath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String datum : data) {
                writer.write(datum + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
