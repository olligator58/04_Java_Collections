package task10150.model;

import java.awt.*;

public class Wall extends CollisionObject {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(210, 105, 30));
        graphics.fillRect(x - width / 2, y - height / 2, width, height);
    }
}
