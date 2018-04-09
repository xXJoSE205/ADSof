package p4.src;

import java.util.List;

public abstract class Nodo implements INodo{

    private String simbolo;

    public Nodo(String simbolo){
        this.simbolo = simbolo;
    }

    public String getRaiz() {
        return simbolo;
    }

    public abstract List<INodo> getDescendientes();

    public abstract void incluirDescendiente(INodo nodo);

    public abstract double calcular();

    public abstract INodo copy();
}
