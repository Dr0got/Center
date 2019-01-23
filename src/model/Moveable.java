package model;

public interface Moveable {
    public enum Direction{CLOCKWISE, ANTICLOCKWISE};
    public void move(double distance);
}
