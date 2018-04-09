package p4.src;

import java.util.ArrayList;
import java.util.List;

public class Funcion extends Nodo{
    private int numOperandos;
    private List<INodo> listaDescendientes;

    public Funcion (String operador, int operandos){
        super(operador);
        listaDescendientes = new ArrayList<>();
        this.numOperandos = operandos;
    }

    public String toString() {
        String cadena = "( " + super.getRaiz();

        for(INodo n : listaDescendientes){
            cadena += n.toString();
        }
        cadena += ") ";

        return cadena;
    }

    public void incluirDescendiente(INodo nodo) {
        listaDescendientes.add(nodo);
    }

    public List<INodo> getDescendientes() {
        return listaDescendientes;
    }

    public INodo copy() {
        Funcion funcionCopy = new Funcion(this.getRaiz(),this.numOperandos);
        funcionCopy.listaDescendientes = this.getDescendientes();
        return funcionCopy;
    }
}
