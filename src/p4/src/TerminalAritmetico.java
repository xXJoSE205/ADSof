package p4.src;

import java.util.ArrayList;
import java.util.List;

public class TerminalAritmetico extends Terminal{

    /**
     * Contructor de TerminalAritmetico
     * @param simbolo simbolo del terminal
     */
    public TerminalAritmetico (String simbolo){
        super(simbolo);
    }

    /**
     * Convierte en una cadena toda la informacion del terminal
     * @return String, la cadena con la informacion
     */
    @Override
    public String toString() {
        return getRaiz()+" ";
    }

    /**
     * Copia el terminal
     * @return INodo, copia del terminal
     */
    @Override
    public INodo copy() {
        return new TerminalAritmetico(getRaiz());
    }

    /**
     * Cambia los descendientes del terminal
     * @param descendientes descendiente para añadir
     */
    @Override
    public void setDescendientes(List<INodo> descendientes) {

    }

    /**
     * Borra el descendiente de la posicion x
     * @param x posicion de la lista que se quiere eliminar
     */
    @Override
    public void borrarDescendiente(int x) {

    }

    /**
     * Añade un descendiente a la posicion x
     * @param nodo nodo que se quiere añadir como descendiente
     * @param x posicion de la lista donde se quiere añadir el nodo
     */
    @Override
    public void anadirDescendiente(INodo nodo, int x) {

    }


}
