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
}
