package model;

public class Point {

    private double r;
    private double angle;
    private double xCenter;
    private double yCenter;

    public Point(double r, double angle, double xCenter, double yCenter){
        this.r = r;
        this.angle = angle;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }



    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public double getR() {
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
    }
}
