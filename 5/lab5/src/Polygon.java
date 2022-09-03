import java.util.ArrayList;

public class Polygon extends Shape {
    /**
     * This a superClass and also a subClass that
     * manage the polygons
     */

    private double sides[];
    private ArrayList<Double> list = new ArrayList<>();

    public Polygon(double ...sides){
        super();
        this.sides = sides;
        for (double i: sides){
            list.add(i);
        }
    }

    public double[] getSides() {
        return sides;
    }

    public String toString(){
        int counter=0;
        String shape = "";
        for (double i: list){
            String side = "side" +counter++ +": " +i;
            shape += "   " +side;
        }
        return shape;
    }

}
