package p4.src;

import java.util.HashMap;
import java.util.List;

/**
 * Esta clase contiene la informacion de la interfaz INodo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public interface INodo {
    String getRaiz();
    List<INodo> getDescendientes();
    void incluirDescendiente(INodo nodo);
    double calcular();
    INodo copy();
    int getId();
    void cruzar(INodo nodo, int id);
    void setDescendientes(List<INodo> descendientes);
    void setId(int id);
    int etiquetar(int x, HashMap<Integer,INodo> etiqueta);
    int getNNodos();
    void borrarDescendiente(int x);
    void anadirDescendiente(INodo nodo, int x);
    INodo buscar(int id);
}
