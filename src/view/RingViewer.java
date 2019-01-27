package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import main.Settings;
import model.Block;
import model.Element;
import model.MoveableBlock;
import model.Ring;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class RingViewer {
    private ArrayList<ElementViewer> viewers;

    private Ring ring;

    public RingViewer(Ring r, Settings settings){
        this.ring = r;
        viewers = new ArrayList<ElementViewer>(4);

        Consumer<Element> elementConsumer = element -> {
            if(element instanceof Block){
                viewers.add(new ElementViewer(settings.blockColor, element));
            }else if(element instanceof MoveableBlock){
                viewers.add(new ElementViewer(settings.moveableBlockColor, element));
            }//TODO player
        };

        r.forEachElement(elementConsumer);
    }

    public void drawRing(Settings set, GraphicsContext ctx){
        double radius = set.startRadius + ring.getLevel()*set.ringWidth;
        double leftPoint = set.xCenter - radius/2;
        double topPoint = set.yCenter - radius/2;
        ctx.strokeArc(leftPoint, topPoint, radius, radius, 0, 360, ArcType.OPEN);

        viewers.forEach(el -> {
            //if(el.isMoveable())
                el.draw(set, ring.getLevel(), ctx);
        });

    }
}
