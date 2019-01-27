package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import main.Settings;
import model.Element;
import model.Moveable;

public class ElementViewer {

    private Color color;

    private Element element;

    public ElementViewer(Color cl, Element el){
        color = cl;
        element = el;
    }

    public void draw(Settings settings, int level, GraphicsContext ctx){
        ctx.setStroke(color);

        double[] angles = element.getAngles();
        double radius = settings.startRadius + (level-1) * settings.ringWidth;

        double leftPoint = settings.xCenter - radius/2;
        double topPoint = settings.yCenter - radius/2;
        ctx.strokeArc(leftPoint, topPoint, radius, radius,  angles[0],  angles[1] - angles[0], ArcType.OPEN);

        double radius2 = settings.startRadius + (level) * settings.ringWidth;
        leftPoint = settings.xCenter - radius2/2;
        topPoint = settings.yCenter - radius2/2;
        ctx.strokeArc(leftPoint, topPoint, radius2, radius2,  angles[0],  angles[1] - angles[0], ArcType.OPEN);

        double[] coords1 = getPointCoords(settings.xCenter, settings.yCenter, angles[0], radius);
        double[] coords2 = getPointCoords(settings.xCenter, settings.yCenter, angles[0], radius2);
        ctx.strokeLine(coords1[0], coords1[1], coords2[0], coords2[1]);

        coords1 = getPointCoords(settings.xCenter, settings.yCenter, angles[1], radius);
        coords2 = getPointCoords(settings.xCenter, settings.yCenter, angles[1], radius2);
        ctx.strokeLine(coords1[0], coords1[1], coords2[0], coords2[1]);

        ctx.setStroke(settings.defaultColor);
    }

    public boolean isMoveable(){
        return element instanceof Moveable;
    }

    private double[] getPointCoords(double xCenter, double yCenter, double angle, double radius){
        //double x1 = (angle < 90.0 || angle > 270) ? xCenter + (radius/2)*Math.cos(Math.toRadians(angle)) : xCenter - (radius/2)*Math.cos(Math.toRadians(angle));
        double x1 = xCenter + (radius/2)*Math.cos(Math.toRadians(angle));
        //double y1 = (angle > 180) ? yCenter - (radius/2)*Math.sin(Math.toRadians(angle)) : yCenter + (radius/2)*Math.sin(Math.toRadians(angle));
        double y1 = yCenter - (radius/2)*Math.sin(Math.toRadians(angle));
        return new double[]{x1, y1};
    }
}