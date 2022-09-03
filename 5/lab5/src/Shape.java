public class Shape {
    /**
     * This is a superClass to avoid repeat a code
     * and manage the shapes
     * @param side
     * @return
     */

    protected double calculatePerimeter(double ...side){
        int sum = 0;
        for(double i :side){
            sum+= i;
        }
        return sum;
    }

    protected double calculateArea(double ...side){
        int sum = 0;
        for(double i :side){
            sum+= i;
        }
        return Math.sqrt(sum);
    }

    public String draw(){
        return " ";
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString(){
        return " ";
    }

}
