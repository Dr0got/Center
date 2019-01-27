package controller;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import main.Settings;
import model.Model;
import view.MainViewer;
import javafx.concurrent.*;

public class Controller {
    Model model;
    MainViewer view;
    Settings settings;

    public Controller(Model m, MainViewer v, Settings set){
        model = m;
        view = v;
        settings = set;
    }

    public void startLevel(){
        AnimationTimer animationTimer = new AnimationTimer(){

            public void handle(long now){
                try {
                    Thread.sleep((long)(1000 / settings.fps));
                    model.move();
                    view.drawRings();
                }catch(InterruptedException e){
                    System.out.println("Thread was Interrupted");
                }
            }
        };
        animationTimer.start();
    }

    private void nextLevel(){
        //TODO
    }
}
