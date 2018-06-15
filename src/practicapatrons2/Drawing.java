package practicapatrons2;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Fran
 */
public class Drawing extends Figure{
    private final List<Figure> components;
    
    public Drawing(List<Figure> components, double x, double y){
        super(x,y);
        this.components = components;
        
    }
    
    public List<Figure> getComponents(){
        return Collections.unmodifiableList(components);
    }
    
    public void addComponent(Figure fig){
        components.add(fig);
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
