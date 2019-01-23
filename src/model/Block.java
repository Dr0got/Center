package model;

import javafx.scene.paint.Color;

public class Block extends Element {
    static{
        color = Color.POWDERBLUE;
    }

    public static Color color;

    public Block(Point less, Point large){
        super(less, large);
    }
}
