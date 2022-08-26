/*
Разложение на множители с помощью рекурсии
*/

public class Task0422 {
    public void recurse(int n) {
        if (n == 1) {
            return;
        }

        int divider = 2;
        while (n % divider != 0) {
            divider++;
        }
        System.out.print(divider + " ");
        recurse(n / divider);
    }
}
