package model;

import main.Settings;

import java.util.function.Consumer;

public class Model {
    private Ring[] rings;
    private Settings settings;
    private int level;

    public Model(Settings settings){
        this.settings = settings;
        //The Game starts from the first level
        level = 0;
        rings = new Ring[2];
        nextLevel();
    }

    public void nextLevel(){
        ++level;
        for(int i = 0; i <= level; ++i){
            rings[i] = new Ring(i+1);
            rings[i].generateElements((int)(rings[i].getSquare(settings.startRadius, settings.ringWidth)/settings.blocksize), settings.part, settings.moveablePart);
        }
    }

    public void move(){
        Consumer<Ring> function = ring -> {
            ring.forEachElement(element -> {
                if(element instanceof MoveableBlock)
                    ((MoveableBlock) element).move(settings.speed);
            });
        };

        forEachRing(function);
    }

    public void forEachRing(Consumer<Ring> function){
        for(Ring ring : rings)
            function.accept(ring);
    }

    public int getLevel(){
        return level;
    }

    public Ring[] getRings(){
        return rings;
    }
}
