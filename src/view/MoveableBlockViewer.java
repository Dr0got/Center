package view;

import javafx.scene.paint.Color;
import model.MoveableBlock;

public class MoveableBlockViewer extends ElementViewer {

    public MoveableBlock block;

    public MoveableBlockViewer(Color cl, MoveableBlock mv){
        this.color = cl;
        this.block = mv;
    }

    @Override
    public void draw(){
        //TODO
    }
}
