package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesHelper {

private static Properties prop = new Properties();
    private File file = new File("C:\\Users\\s4876564\\IdeaProjects\\PIC\\src\\resources\\environment.properties");
    private FileInputStream fileInput = null;

    public  String readProperty(String propertyName) {
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Properties file not found or is locked by another program.");
            e.printStackTrace();
        }
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            System.out.println("Error reading properties file.");
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

}
