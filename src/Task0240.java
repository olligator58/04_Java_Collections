import java.io.*;

/*
Читаем из потока
*/

public class Task0240 {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:/work/JavaRush/files/secretPasswords.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter result = new StringWriter();
        if (is == null) {
            return result;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String line = reader.readLine();
                result.write(line);
            }
        }
        return result;
    }
}
