/**
 * Esta clase contiene la informacion de una Funcion
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcion extends Nodo{
    /** Numero de operandos*/
    private int numOperandos;
    /** Lista de los nodos descendientes*/
    private List<INodo> descendientes;

    /**
     * Constructor de Funcion
     *
     * @param operador Simbolo representativo de la funcion
     * @param operandos Numero de operandos de la funcion
     * @throws IllegalArgumentException si el numero de operandos es menor que 2
     */
    public Funcion(String operador, int operandos) throws IllegalArgumentException{
        super(operador);
        if(operandos<2){
            throw new IllegalArgumentException("Numero de operandos menor que 2: "+operandos);
        }
        descendientes = new ArrayList<>();
        this.numOperandos = operandos;
    }

    /**
     * Devuekve el numero de operandos de la funcion
     *
     * @return Entero, numero de operandos
     */
    public int getNumOperandos() {
        return numOperandos;
    }

    /**
     * Convierte en una cadena toda la informacion de la funcion
     *
     * @return Cadena con la informacion de la funcion
     */
    @Override
    public String toString() {
        String cadena = "( " + super.getRaiz()+" ";

        for(INodo n : descendientes){
            cadena += n.toString();
        }
        cadena += ") ";

        return cadena;
    }

    /**
     * Incluye un nodo descendiente a la funcion, solo si el numero de descendientes es menor que el numero de operandos
     *
     * @param nodo Nodo que se quiere añadir
     */
    @Override
    public void incluirDescendiente(INodo nodo) {
        if(descendientes.size() < numOperandos) {
            descendientes.add(nodo);
        }
    }

    /**
     * Devuelve una lista con todos los decendientes de la funcion
     *
     * @return Lista con todos los nodos descendientes
     */
    @Override
    public List<INodo> getDescendientes() {
        return descendientes;
    }

    /**
     * Establece los descendientes de la funcion
     *
     * @param descendientes Lista con los descendientes a añadir
     * @throws NullPointerException Si la lista es null
     */
    public void setDescendientes(List<INodo> descendientes) throws NullPointerException{
        if(descendientes==null){
            throw new NullPointerException("Los descendientes son null");
        }
        this.descendientes=descendientes;
    }

    /**
     * Definicion del metodo calcular
     *
     * @return double con el resultado del calculo
     */
    public abstract double calcular();

    /**
     * Definicion del metodo copy
     *
     * @return INodo, copia del nodo indicado
     */
    public abstract INodo copy();

    public List<INodo> getDesNodo(){
        return descendientes;
    }
}
