/**
 * Esta clase contiene la informacion de la interfaz INodo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

import java.util.List;

public interface INodo {
    String getRaiz();
    List<INodo> getDescendientes();
    void incluirDescendiente(INodo nodo);
    double calcular();
    INodo copy();
    int getId();
    INodo buscar( int id);
    void cruzar(INodo nodo, int id);
    void setDescendientes(List<INodo> descendientes);
    void setId(int id);
    void etiquetar();
    List<INodo> getDesNodo();
}
