package practicapatrons2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Fran
 */
public class BuilderTest {
       
    private Circle c;
    private Rectangle r;
    private Builder b;
    private List<Figure> components;
    private Drawing resultBuilder;
    private Drawing resultDrawing;
    
    @Before
    public void setUp() {
        b = new Builder(12, 32);
        c = new Circle(10, 10, 2);
        r = new Rectangle(10, 15, 20, 25);
        components = new ArrayList<>();
        components.add(c);
        components.add(r);
    }
    

    /**
     * Test per fer la comprovació del Builder de figures a un Drawing
     */
    @Test
    public void testBuild() {
        System.out.println("Builder build test");
        
        // Creacio de figures al Drawing mitjançant un Builder
        b.add(c)
                .add(r)
                .build();
        resultBuilder = b.build();
        
        // Verificacio del Builder correctament construit
        assertEquals(resultBuilder.getComponents().size(), 2);
        assertEquals(resultBuilder.getComponents().get(0), c);
        assertEquals(resultBuilder.getComponents().get(1), r);
        
        // Creacio de figures directament a un Drawing
        resultDrawing = new Drawing(Collections.unmodifiableList(components), 12, 32);

        // Verificacio dels components entre els 2 drawings creats
        assertEquals(resultBuilder.getComponents(), resultDrawing.getComponents());

    }
    
}
