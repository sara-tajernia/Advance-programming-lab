public class Triangle extends Polygon {

    /**
     * this is a subClass and can find area and perimeter
     * and include a toString method
     */

    double sides[];
    public Triangle(double ...sides){
        super(sides);
        this.sides = sides;
    }


    @Override
    public double calculatePerimeter(double ...side){
        int sum = 0;
        for(double i: sides){
            sum+= i;
        }
        return sum;
    }

    @Override
    public double calculateArea(double ...side){
        double test[] = new double[3];
        int counter=0;
        int sum = 0;
        for(double i: sides){
            test[counter] = i;
            counter++;
            sum+= i;
        }
        return Math.sqrt(sum*(sum-sides[0])*(sum-sides[1])*(sum-sides[2]));
    }


    public boolean isEquilateral (){
        if(sides[0] == sides[1] && sides[1] == sides[2])
            return true;
        else
            return false;
    }

    public String draw(){
        return "Triangle";
    }

}
