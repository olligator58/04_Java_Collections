package task0784;

import java.util.ArrayList;
import java.util.List;

/*
Шаблонный метод
*/

public class Solution {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        games.add(new Football());
        games.add(new Basketball());
        games.add(new Tennis());

        for (Game game : games) {
            game.run();
            System.out.println("---------------------------------------------");
        }
    }
}
