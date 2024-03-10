package org.example.service;

import java.util.Collections;
import java.util.List;

public class SortService {
    private static final String splitRegex = ";";
    public static void quickSort(List<String> data, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int temp = Integer.parseInt(data.get((left + right) / 2).split(splitRegex)[0]);
        do {
            while (Integer.parseInt(data.get(left).split(splitRegex)[0]) < temp) {
                left++;
            }
            while (Integer.parseInt(data.get(right).split(splitRegex)[0]) > temp) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    Collections.swap(data, left, right);
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < endIndex) {
            quickSort(data, left, endIndex);
        }
        if (startIndex < right) {
            quickSort(data, startIndex, right);
        }
    }
}
