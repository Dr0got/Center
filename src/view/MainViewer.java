package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import main.Settings;
import javafx.scene.canvas.GraphicsContext;
import model.Model;
import model.Ring;

import java.util.function.Consumer;

public class MainViewer {
    private Settings set;
    private GraphicsContext ctx;

    public MainViewer(Settings settings, GraphicsContext ctx){
        set = settings;
        this.ctx = ctx;
    }

    public void drawStart(){
        drawWeb();

        ctx.fillArc(set.xCenter - set.startRadius/2, set.yCenter - set.startRadius/2, set.startRadius, set.startRadius, 0, 360, ArcType.OPEN );
        ctx.setStroke(Color.WHITE);
        ctx.strokeText("10.00", set.xCenter - (set.startRadius/1.5), set.yCenter - (set.startRadius/2));
        ctx.setStroke(Color.BLACK);
    }

    public void drawModel(Model model){
        Consumer<Ring> function = ring -> {
            double radius = set.startRadius + ring.getLevel()*set.ringWidth;
            double leftPoint = set.xCenter - radius/2;
            double topPoint = set.yCenter - radius/2;
            ctx.strokeArc(leftPoint, topPoint, radius, radius, 0, 360, ArcType.OPEN);
        };

        model.forEachRing(function);
    }

    private void drawWeb(){
        ctx.setStroke(Color.RED);
        for(int i = 0; i <= 600; i+=100){
            ctx.strokeLine(i, 0, i, 600);
        }
        for(int i = 0; i <= 600; i+=100){
            ctx.strokeLine(0, i, 600, i);
        }
        ctx.setStroke(Color.BLACK);
    }
}
