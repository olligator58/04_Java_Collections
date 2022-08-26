/* 
Ханойские башни
*/

public class Task0424 {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings == 1) {
            System.out.println(String.format("from %s to %s", a, b));
            return;
        }
        moveRing(a, c, b, numRings - 1);
        System.out.println(String.format("from %s to %s", a, b));
        moveRing(c, b, a, numRings - 1);
    }
}