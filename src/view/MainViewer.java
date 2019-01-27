package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import main.Settings;
import javafx.scene.canvas.GraphicsContext;
import model.Model;

import java.util.Arrays;

public class MainViewer {
    private Settings set;
    private GraphicsContext ctx;
    private RingViewer[] ringViewers;

    public MainViewer(Settings settings, GraphicsContext ctx){
        set = settings;
        this.ctx = ctx;
        ctx.setLineWidth(5);
    }

    //Before start of each level
    public void refreshModel(Model model){
        ringViewers = new RingViewer[model.getLevel()+1];
        Arrays.asList(model.getRings()).stream().forEach(ring -> ringViewers[ring.getLevel()-1] = new RingViewer(ring, set));
    }

    public void drawStart(Model model){
        //drawWeb();

        ctx.fillArc(set.xCenter - set.startRadius/2, set.yCenter - set.startRadius/2, set.startRadius, set.startRadius, 0, 360, ArcType.OPEN );
        ctx.setStroke(Color.WHITE);
        ctx.strokeText("10.00", set.xCenter - (set.startRadius/1.5), set.yCenter - (set.startRadius/2));
        ctx.setStroke(Color.BLACK);

        refreshModel(model);
        drawRings();
    }

    public void drawRings(){
        for(RingViewer rv : ringViewers)
            rv.drawRing(set, ctx);
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
