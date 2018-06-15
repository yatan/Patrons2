package practicapatrons2;

/**
 *
 * @author Fran
 */
public class AreaDoubler implements Visitor{
    private Figure resultFigure;
    
    public Figure getFigureDoubled(){
        return resultFigure;
    }

    @Override
    public void visit(Circle c){
        double doubleRadius = c.getRadius()* Math.sqrt(2.0);
        resultFigure = new Circle(c.getX(), c.getY(), doubleRadius);
    }
    
    @Override
    public void visit(Rectangle r){
        double doubleHeight = r.getHeight() * Math.sqrt(2.0);
        double doubleWidth = r.getWith()* Math.sqrt(2.0);
        resultFigure = new Rectangle(r.getX(), r.getY(), doubleHeight, doubleWidth);
    }
    
    @Override
    public void visit(Drawing d){
        Builder b = new Builder(d.getX(), d.getY());
        AreaDoubler a = new AreaDoubler();
        for(Figure f : d.getComponents()){
            f.accept(a);
            b.add(a.getFigureDoubled());
        }
        resultFigure = b.build();
    }
    
}
