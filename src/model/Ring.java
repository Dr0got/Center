package model;

import java.util.ArrayList;

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

    public void generateElements(){
        double S = Math.PI*50;
    }

    public void addElement(Element elem){
        elements.add(elem);
    }

    public void removeElement(Element elem){
        elements.remove(elem);
    }
}
