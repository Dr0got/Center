package model;

public abstract class Element {
    protected Point lessPoint;
    protected Point largerPoint;

    public Element(Point less, Point large){
        lessPoint = less;
        largerPoint = large;
    }
}
