package practicapatrons2;

/**
 *
 * @author Fran
 */
public class Rectangle extends Figure{
    private final double width;
    private final double height;
    
    public Rectangle(double x, double y, double w, double h){
        super(x,y);
        width = w;
        height = h;
    }
    
    public double getWith(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }    
}
