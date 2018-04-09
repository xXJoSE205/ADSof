package p4.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcion extends Nodo{
    private int numOperandos;
    private List<INodo> descendientes;

    public Funcion(String operador, int operandos){
        super(operador);
        descendientes = new ArrayList<>();
        this.numOperandos = operandos;
    }

    public int getNumOperandos() {
        return numOperandos;
    }

    @Override
    public String toString() {
        String cadena = "( " + super.getRaiz();

        for(INodo n : descendientes){
            cadena += n.toString();
        }
        cadena += ") ";

        return cadena;
    }

    @Override
    public void incluirDescendiente(INodo nodo) {
        if(descendientes.size() < numOperandos) {
            descendientes.add(nodo);
        }
    }

    @Override
    public List<INodo> getDescendientes() {
        List<INodo> descen = new ArrayList<>();
        for(INodo n: descendientes){
            descen.addAll(n.getDescendientes());
        }
        return descen;
    }

    public abstract double calcular();

    public abstract INodo copy();
}
