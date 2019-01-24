package model;

public abstract class Element {
    protected Point lessPoint;
    protected Point largerPoint;

    public Element(Point less, Point large){
        lessPoint = less;
        largerPoint = large;
    }

    protected boolean isInside(Point p){
        return p.getAngle() > lessPoint.getAngle() && p.getAngle() < largerPoint.getAngle();
    }

    public boolean isInside(Element el){
        return isInside(el.lessPoint) || isInside(el.largerPoint);
    }

    public double[] getAngles(){
        return new double[]{lessPoint.getAngle(), largerPoint.getAngle()};
    }
}
