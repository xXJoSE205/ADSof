package p4.src;

import java.util.List;

public interface INodo {
    String getRaiz();
    List<INodo> getDescendientes();
    void incluirDescendiente(INodo nodo);
    double calcular();
    INodo copy();
    void etiquetar();
}
