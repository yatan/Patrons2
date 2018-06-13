package practicapatrons2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Fran
 */
public class Builder {
    private final List<Figure> components  = new ArrayList<>();
    private double x;
    private double y;
    
    public Builder(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Builder add(Figure fig){
        components.add(fig);
        return this;
    }
    
    public Drawing build(){
        return new Drawing(Collections.unmodifiableList(components), x, y);
    }
}
