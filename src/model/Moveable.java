package model;

import java.util.Random;

public interface Moveable {
    enum Direction{CLOCKWISE, ANTICLOCKWISE};
    void move(double distance);

    static Direction getRandomDirection(){
        int temp = (new Random()).nextInt(2);
        return (temp == 0) ? Direction.CLOCKWISE : Direction.ANTICLOCKWISE;
    }
}
