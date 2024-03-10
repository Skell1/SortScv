package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class SortScvTest {
    private static final String resoursePath = "src/test/resources/source.csv";
    private static final String resultPath = "src/test/resources/sorted.csv";

    @Test
    void mainTest() {
        try(PrintWriter writer = new PrintWriter(resoursePath)) {
            String data = "46471100;Lorne;Raama;Lorne.Raama@yopmail.com;Lorne.Raama@gmail.com;police officer\n" +
                    "24260020;Ebonee;Hirsch;Ebonee.Hirsch@yopmail.com;Ebonee.Hirsch@gmail.com;police officer\n" +
                    "46471100;Margarette;Tomasina;Margarette.Tomasina@yopmail.com;Margarette.Tomasina@gmail.com;worker\n" +
                    "95296361;Joeann;Mozelle;Joeann.Mozelle@yopmail.com;Joeann.Mozelle@gmail.com;firefighter\n" +
                    "15418949;Nollie;Tound;Nollie.Tound@yopmail.com;Nollie.Tound@gmail.com;worker\n";
            writer.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        SortScv.resoursePath = resoursePath;
        SortScv.resultPath = resultPath;
        SortScv.main(new String[]{});

        try(BufferedReader br = new BufferedReader(new FileReader(resultPath))) {
            Assertions.assertEquals(br.readLine().split(";")[0], "15418949");
            Assertions.assertEquals(br.readLine().split(";")[0], "24260020");
            Assertions.assertEquals(br.readLine().split(";")[0], "46471100");
            Assertions.assertEquals(br.readLine().split(";")[0], "46471100");
            Assertions.assertEquals(br.readLine().split(";")[0], "95296361");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File resultFile = new File(resultPath);
        File parentFile = resultFile.getParentFile();
        File resourseFile = new File(resoursePath);
        resultFile.delete();
        parentFile.delete();
        resourseFile.delete();
    }
}