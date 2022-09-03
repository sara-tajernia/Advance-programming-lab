public class Main {
    /**
     *  Shape
     *  we use this class to test all the classes that we made
     *  and add a different shapes with different kind also can
     *  print area and perimeter
     *  <h2>Library  simulation  class</h2>
     *  @author Sara Tajernia
     *  @version 1.00
     *  @since 1399-1-21
     */


    public static void main(String[] args) {

        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle(1,4,1,4);
        Rectangle rect2 = new Rectangle(8,5,8,5);
        Rectangle rect3 = new Rectangle(6,6,6,6);

        Triangle tri1 = new Triangle(2,2,2);
        Triangle tri2 = new Triangle(4,4,6);

        Paint paint = new Paint();

        paint.addShape(circle1);
        paint.addShape(circle2);

        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(rect3);

        paint.addShape(tri1);
        paint.addShape(tri2);


        paint.drawAll();                         //print all kind of shapes with their perimeter and area
        paint.describeEqualSides();              //print squares and equilateral with their sides
        paint.printAll();                        //print all the shapes with their sides

    }
}
