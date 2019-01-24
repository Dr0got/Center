package view;

import javafx.scene.paint.Color;
import model.Block;

public class BlockViewer extends ElementViewer{

    public Block block;

    public BlockViewer(Color cl, Block bl){
        this.color = cl;
        this.block = bl;
    }

    @Override
    public void draw(){
        //TODO
    }
}
