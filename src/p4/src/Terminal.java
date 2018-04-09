package p4.src;

import java.util.ArrayList;
import java.util.List;

public class Terminal extends Nodo{

    public Terminal (String simbolo){
        super(simbolo);
    }

    public String toString() {
        return super.getRaiz()+" ";
    }

    public double calcular() {
        return 1;
    }

    public List<INodo> getDescendientes() {
        return new ArrayList<>();
    }

    @Override
    public void incluirDescendiente(INodo nodo) {
    }

    public INodo copy() {
        return new Terminal(this.getRaiz());
    }
}
