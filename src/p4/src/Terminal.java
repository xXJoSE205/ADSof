package p4.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Terminal extends Nodo{

    private static double valor;

    public Terminal (String simbolo){
        super(simbolo);
    }

    public abstract String toString();

    public double calcular(){
        return valor;
    }

    public List<INodo> getDescendientes() {
        return new ArrayList<>();
    }

    @Override
    public void setDescendientes(List<INodo> descendientes) {
    }

    @Override
    public void incluirDescendiente(INodo nodo) {
    }

    public abstract INodo copy();

    public static void setValor(double valor){
        Terminal.valor = valor;
    }
}
