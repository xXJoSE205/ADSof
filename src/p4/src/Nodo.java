package p4.src;

import java.util.List;

public abstract class Nodo implements INodo{

    private String raiz;

    public Nodo(String simbolo){
        this.raiz = simbolo;
    }

    public String getRaiz() {
        return raiz;
    }

    public List<INodo> getDescendientes() {
        return null;
    }

    public void incluirDescendiente(INodo nodo) {
        return;
    }

    public double calcular() {
        return 0;
    }

    public INodo copy() {
        return null;
    }

}
