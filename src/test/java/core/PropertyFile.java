package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    Properties properties = new Properties();

    public PropertyFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
    }

    public String getProperty(String fieldValue) {
        return properties.getProperty(fieldValue);
    }
}
