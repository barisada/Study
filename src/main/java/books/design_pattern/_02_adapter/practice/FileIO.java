package books.design_pattern._02_adapter.practice;

import java.io.IOException;

/**
 * Created on 2018-05-17.
 */
public interface FileIO {

    void readFromFile(String fileName) throws IOException;
    void writeToFile(String fileName) throws IOException;
    void setValue(String key, String value);
    String getValue(String key);
}
