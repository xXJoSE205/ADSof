/**
 * Esta clase contiene la informacion de un Nodo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

import java.util.List;

public abstract class Nodo implements INodo{
    /** Raiz, simbolo caracteristico*/
    private String simbolo;
    /** ID del nodo*/
    private int id;

    /**
     * Constructor de Nodo
     *
     * @param simbolo Simbolo caracteristico del nodo
     */
    public Nodo(String simbolo){
        this.simbolo = simbolo;
    }

    /**
     * Devuelve la raiz, simbolo, del nodo
     *
     * @return Cadena con la raiz, simbolo
     */
    public String getRaiz() {
        return simbolo;
    }

    /**
     * Definicion del metodo getDescendientes
     *
     * @return Lista con los descendientes del nodo
     */
    public abstract List<INodo> getDescendientes();

    /**
     * Definicion del metodo incluirDescendiente
     */
    public abstract void incluirDescendiente(INodo nodo);

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

    /**
     * Definicion del metodo setDescendientes
     */
    public abstract void setDescendientes(List<INodo> descendientes);

    /**
     * Devuekve el ID del nodo
     *
     * @return Entero, ID del nodo
     */
    public int getId(){
        return id;
    }

    /**
     * Devuelve el nodo con el ID indicado
     *
     * @param id ID del nodo a buscar
     * @return INodo, nodo con el correspondiente ID
     * @throws IllegalArgumentException Si el id es menor que 1
     */
    public INodo buscar(int id) throws IllegalArgumentException{
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        List<INodo> aux=getDescendientes();
        for(INodo nodo:aux){
            if(nodo.getId()==id){
                return nodo;
            }
        }
        return null;
    }

    /**
     *
     * @param nodo
     * @param id
     */
    public void cruzar(INodo nodo, int id){
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        for(int i=0; i<getDescendientes().size();i++){
            if(getDescendientes().get(i).getId()==id){
                setDescendientes(nodo.getDescendientes());
                return;
            }
        }
    }

    /**
     * Establece el ID del nodo
     *
     * @param id ID a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece un ID a cada nodo por orden de profundidad
     */
    public void etiquetar() {
        int i=1;
        for(INodo nodo :getDescendientes()){
            nodo.setId(i);
            i++;
        }
    }
}
