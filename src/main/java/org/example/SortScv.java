package org.example;

import org.example.service.FileService;
import org.example.service.SortService;

import java.util.List;

public class SortScv {
    protected static String resoursePath = "src/main/resources/source.csv";
    protected static String resultPath = "src/main/resources/sorted.csv";
    public static void main(String[] args) {
        List<String> data = FileService.loadScvData(resoursePath);
        SortService.quickSort(data, 0, data.size() - 1);
        FileService.generateFile(data, resultPath);
    }
}