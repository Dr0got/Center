package model;

public class Point implements Comparable<Point>{

    private double angle;

    public Point(double angle){
        setAngle(angle);
    }

    public void setAngle(double angle) {
        if(angle < 0)
            this.angle = 360 + angle;
        else if(angle > 360)
            this.angle = angle - 360;
        else
            this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public int compareTo(Point p){
        return (int)(this.angle - p.angle);
    }
/*    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getY(){
        return r * Math.sin(angle);
    }

    public double getX(){
        return r * Math.cos(angle);
    }*/
}
