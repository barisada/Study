package books.design_pattern._02_adapter;

import books.design_pattern._02_adapter.practice.FileIO;
import books.design_pattern._02_adapter.practice.FileProperties;

import java.io.IOException;
import java.util.Properties;

/**
 * Created on 2018-05-17.
 */
public class PracticeTest {
    public static void main(String[] args) throws IOException {
        FileIO f = new FileProperties(new Properties());
        f.readFromFile("src/main/resources/practice/file.txt");
        System.out.println("value of read from file: " + f.getValue("year"));

        f.setValue("year", "2018");
        f.setValue("month", "05");
        f.setValue("day", "17");
        f.writeToFile("newfile.txt");
    }
}
