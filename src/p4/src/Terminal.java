package p4.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Terminal extends Nodo{

    public Terminal (String simbolo){
        super(simbolo);
    }

    public abstract String toString();

    public abstract double calcular();

    public List<INodo> getDescendientes() {
        return new ArrayList<>();
    }

    @Override
    public void incluirDescendiente(INodo nodo) {
    }

    public abstract INodo copy();
}
