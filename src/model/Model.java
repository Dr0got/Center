package model;

import main.Settings;

import java.util.function.Consumer;

public class Model {
    private Ring[] rings;
    Settings settings;
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

    public void forEachRing(Consumer<Ring> function){
        for(Ring ring : rings)
            function.accept(ring);
    }
}
