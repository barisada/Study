package books.design_pattern._02_adapter.practice;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * Created on 2018-05-17.
 */
public class FileProperties implements FileIO {
    private Properties properties;

    public FileProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void readFromFile(String fileName) throws IOException {
        properties.load(new FileInputStream(fileName));
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        String comments = "#written by FileProperties";
        properties.store(new FileWriter(fileName), comments);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
