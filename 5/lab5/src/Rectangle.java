public class Rectangle extends Polygon {

    /**
     * this is a subClass and can find area and perimeter
     * and include a toString method
     */

    double sides[];
    public Rectangle(double ...sides){
        super(sides);
        this.sides = sides;
    }

    @Override
    public double calculatePerimeter(double ...side){
        int perimate = 0;
        for(double i: sides){
            perimate+= i;
        }
        return perimate;
    }


    @Override
    public double calculateArea(double ... side){
        int area =1;
        for(double i: sides){
            area*= i;
        }
        return Math.sqrt(area);
    }


    public boolean isSquare(){
        if(sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3])
            return true;
        else
            return false;
    }

    public String draw(){
        return "Rectangle";
    }

}



