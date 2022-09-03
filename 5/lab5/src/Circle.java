public class Circle extends Shape {

    /**
     * this is a subClass and can find area and perimeter
     * and include a toString method
     */
    private double R;

    public Circle(double radius){
        super();
        this.R = radius;
    }

    public double getRadius() {
        return R;
    }

    @Override
    public double calculatePerimeter(double ...radius){
        double perimate = 2* 3.14* R;
        return perimate;
    }

    @Override
    public double calculateArea(double ...radius){
        double area = 3.14* R* R;
        return area;
    }

    public String toString(){
        String shape = "   radius: " +R;
        return shape;
    }

    public String draw(){
        return "Circle";
    }
}
