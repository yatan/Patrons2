/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapatrons2;

/**
 *
 * @author Fran
 */
public interface Visitor {
    void visit(Drawing d);
    void visit(Circle c);
    void visit(Rectangle r);
}
