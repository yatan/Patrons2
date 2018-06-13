package practicapatrons2;

/**
 *
 * @author Fran
 */
public class Circle extends Figure{
    private double r;
    
    public Circle(double x, double y, double radius){
        super(x,y);
        this.r = radius;
    }
    
    public double getRadius(){
        return r;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
