package practicapatrons2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fran
 */
public class AreaDoublerTest {
    
    public AreaDoublerTest() {
    }
    
    private Circle c;
    private Rectangle r;
    private Builder b;
    private Drawing d;
    private AreaDoubler ad;
    
    @Before
    public void setUp() {
        b = new Builder(12, 32);
        c = new Circle(10, 10, 2);
        r = new Rectangle(10, 15, 20, 25);
                b.add(c)
                .add(r)
                .build();
        d = b.build();
    }
    

    /**
     * Test per verificar AreaDoubler per un Circle
     */
    @Test
    public void testCircleDoubler() {
        System.out.println("testCircleDoubler");
        ad = new AreaDoubler();
        c.accept(ad);
        
        Circle dc = (Circle)ad.getFigureDoubled();
        double r2 = c.getRadius()* Math.sqrt(2.0);
        assertEquals(r2, dc.getRadius(), 0.02);

    }

    /**
     * Test per verificar AreaDoubler per un Rectangle
     */
    @Test
    public void testRectangleDoubler() {
        System.out.println("testRectangleDoubler");
        ad = new AreaDoubler();
        r.accept(ad);
        
        Rectangle dr = (Rectangle)ad.getFigureDoubled();
        double h2 = r.getHeight()* Math.sqrt(2.0);
        double w2 = r.getWidth()* Math.sqrt(2.0);
        
        assertEquals(h2, dr.getHeight(), 0.02);
        assertEquals(w2, dr.getWidth(), 0.02);

    }

    /**
     * Test per verificar AreaDoubler per un Drawing
     */
    @Test
    public void testDrawingDoubler() {
        System.out.println("testDrawingDoubler");
        ad = new AreaDoubler();
        d.accept(ad);
        
        Drawing dd = (Drawing)ad.getFigureDoubled();
        Circle dd_c = (Circle) dd.getComponents().get(0);
        Rectangle dd_r = (Rectangle) dd.getComponents().get(1);
        
        
        Circle c_doubled = (Circle)d.getComponents().get(0);
        double c_radius_doubled = c_doubled.getRadius()* Math.sqrt(2.0);
        
        assertEquals(c_radius_doubled, dd_c.getRadius(), 0.02);
                
        Rectangle r_doubled = (Rectangle)d.getComponents().get(1);
        double r_height_doubled = r_doubled.getHeight()* Math.sqrt(2.0);
        double r_width_doubled= r_doubled.getWidth()*Math.sqrt(2.0);
        
        assertEquals(r_height_doubled, dd_r.getHeight(), 0.02);
        assertEquals(r_width_doubled, dd_r.getWidth(), 0.02);
        
    }

    
}
