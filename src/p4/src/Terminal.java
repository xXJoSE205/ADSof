package p4.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene la informacio  de un Terminal
 *
 * @author Jorge Mateo Segura y Jose Antonio Muñoz Ortega
 */
public abstract class Terminal extends Nodo{
    /** Valor numerico de la expresion*/
    private static double valor;

    /**
     * Constructor del terminal
     * @param simbolo simbolo de la raiz
     */
    public Terminal (String simbolo){
        super(simbolo);
    }

    /**
     * Definicion del metodo toString
     * @return String con el simbolo de la raiz
     */
    public abstract String toString();

    /**
     * Devuelve el numero de valor
     * @return Double, valor de la expresion
     */
    public double calcular(){
        return valor;
    }

    /**
     * Devuelve una lista vacia, ya que no hay descendientes
     * @return List, lista vacia
     */
    public List<INodo> getDescendientes() {
        return new ArrayList<>();
    }

    /**
     * Cambia la lista de descendientes
     * @param descendientes descendiente para añadir
     */
    @Override
    public void setDescendientes(List<INodo> descendientes) {
    }

    /**
     * Añade un descendiente
     * @param nodo nodo que añadir al descendiente
     */
    @Override
    public void incluirDescendiente(INodo nodo) {
    }

    /**
     * Definicion del metodo copy
     * @return INodo, nodo copiado
     */

    public INodo copy(){
        return new TerminalAritmetico(getRaiz());
    }

    /**
     * Cambia el valor del terminal
     * @param valor Double, nuevo valor
     */
    public static void setValor(double valor){
        Terminal.valor = valor;
    }
}
