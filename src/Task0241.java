import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/

public class Task0241 {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        if (throwable != null) {
            throwable.printStackTrace(new PrintWriter(stringWriter));
        }
        return stringWriter.toString();
    }
}
