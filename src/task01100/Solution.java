package task01100;

import java.io.*;
import java.io.IOException;
import java.util.Properties;

/*
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/task01100/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/task01100/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/task01100/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties result = new Properties();
        try {
            if (fileName.toLowerCase().endsWith(".xml")) {
                result.loadFromXML(new FileInputStream(fileName));
            } else {
                result.load(new FileReader(fileName));
            }
        } catch (IOException ignore) {
        }
        return result;
    }
}
