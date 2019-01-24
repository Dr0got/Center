package model;

public class MoveableBlock extends Element implements Moveable{
    Direction direct;

    public MoveableBlock(Point less, Point large, Direction dir){
        super(less, large);
        direct = dir;
    }

    @Override
    public void move(double distance){
        if(direct == Direction.CLOCKWISE){
            lessPoint.setAngle(lessPoint.getAngle()-distance);
            largerPoint.setAngle(largerPoint.getAngle()-distance);
        }else{
            lessPoint.setAngle(lessPoint.getAngle()+distance);
            largerPoint.setAngle(largerPoint.getAngle()+distance);
        }
    }
}
