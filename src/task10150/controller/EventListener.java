package task10150.controller;

import task10150.model.Direction;

public interface EventListener {

    void move(Direction direction);

    void restart();

    void startNextLevel();

    void levelCompleted(int level);
}
