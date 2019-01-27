package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ring {

    private int level;
    private ArrayList<Element> elements;

    public Ring(int level){
        this.level = level;
        elements = new ArrayList(4);
    }

    public int getLevel(){
        return this.level;
    }

    public void generateElements(int amount, double part, double moveablePart){
        //angle of each element of the ring
        double angle = 360 * part / amount;
        //Direction of element's moving
        Moveable.Direction direct = Moveable.getRandomDirection();
        for(int i = 0; i < amount; ++i) {
            Point[] points;
            try {
                points = generateElement(angle);
            }catch(StackOverflowError error){
                points = generateElement(angle);
            }
            elements.add((i <= amount/3) ? new Block(points[0], points[1]) : new MoveableBlock(points[0], points[1], direct));
        }
    }

    public boolean addElement(Element elem){
        //TODO
        elements.add(elem);
        return true;
    }

    public void removeElement(Element elem){
        elements.remove(elem);
    }

    public double getSquare(double startRadius, double ringWidth){
        double S1 = Math.PI * Math.pow(startRadius + (level-1) * ringWidth, 2);
        double S2 = Math.PI * Math.pow(startRadius + level * ringWidth, 2);
        return S2 - S1;
    }

    private Point[] generateElement(double angle){
        double startAngle = EvenRandom(0.0, 360.0);
        Point lessPoint = new Point(startAngle);
        if(forEachElementIs(el -> el.isInside(lessPoint))){
            Point largePoint = new Point(startAngle + angle);
            if(forEachElementIs(el -> el.isInside(largePoint))){
                Point[] points = new Point[]{lessPoint, largePoint};
                Arrays.sort(points);
                return points;
            }
            else{
                Point lesserPoint = new Point(startAngle-angle);
                if(forEachElementIs(el -> el.isInside(lesserPoint))){
                    Point[] points = new Point[]{lesserPoint, lessPoint};
                    Arrays.sort(points);
                    return points;
                }
                else return generateElement(angle);
            }
        }else{
            return generateElement(angle);
        }
    }

    //returns a number from a to b
    private double EvenRandom(double a, double b){
        return (Math.random()*(b-a)) + a;
    }

    private boolean forEachElementIs(Predicate<Element> predicate){
        for(Element el : elements){
            if(predicate.test(el))
                return false;
        }
        return true;
    }

    public void forEachElement(Consumer<Element> function){
        for(Element el : elements)
            function.accept(el);
    }
}