import java.util.ArrayList;

/**
 * This class is for all the prints in different ways
 * like print the shape kind and sides or area and perimeter
 * or print squares and equilaterals
 */
public class Paint {

    ArrayList<Shape> ObjShape = new ArrayList<>();

    public void addShape(Shape shape){
        ObjShape.add(shape);
    }

    public void drawAll(){
        for (Shape i: ObjShape) {
            Shape test = i;
            System.out.println(test.draw());
            System.out.printf("Perimeter: %.2f\n", test.calculatePerimeter());
            System.out.printf("Area: %.3f\n\n", test.calculateArea());
        }
    }

    public void printAll(){
        for (Shape i: ObjShape){
            Shape test = i;
            System.out.println(test.draw());
            System.out.println(test.toString());
        }
    }

    public void describeEqualSides(){
        for (Shape i: ObjShape) {
            if (i instanceof Triangle) {
                Triangle triangle = (Triangle) i;
                if(triangle.isEquilateral()){
                    System.out.println("Equilateral");
                    System.out.println(triangle.toString());
                }

            }
            if (i instanceof Rectangle){
                Rectangle rectangle = (Rectangle)i;
                if(rectangle.isSquare()){
                    System.out.println("Square");
                    System.out.println(rectangle.toString());
                }
            }
        }
    }

}
