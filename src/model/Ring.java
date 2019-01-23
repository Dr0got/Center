package model;

import java.util.ArrayList;

public class Ring {

    //radius of the circle, that is closer to the center
    private double r;

    private ArrayList<Element> elements;

    public Ring(double r){
        this.r = r;
        elements = new ArrayList(4);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void addElement(Element elem){
        elements.add(elem);
    }
}
