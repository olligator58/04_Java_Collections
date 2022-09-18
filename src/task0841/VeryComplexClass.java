package task0841;

/*
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileInputStream input = new FileInputStream("");
    }

    public static void main(String[] args) throws Exception {
        new VeryComplexClass().veryComplexMethod();

    }
}
