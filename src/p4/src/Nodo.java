package p4.src;

import java.util.HashMap;
import java.util.List;

/**
 * Esta clase contiene la informacion de un Nodo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public abstract class Nodo implements INodo{
    /** Raiz, simbolo caracteristico*/
    private final String simbolo;
    /** ID del nodo*/
    private int id;

    /**
     * Constructor de Nodo
     *
     * @param simbolo Simbolo caracteristico del nodo
     */
    Nodo(String simbolo){
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
     * Si encuentra el nodo, cambia sus descendientes por el nodo dado
     * @param nodo nodo para cambiar
     * @param id ID del nodo donde realizar el cruce
     * @throws IllegalArgumentException Si el id es menor que 1
     * @throws NullPointerException Si el nodo es null
     */
    public void cruzar(INodo nodo, int id) throws NullPointerException, IllegalArgumentException{
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        if(!getRaiz().equals("x")) {
            for (int i = 0; i < getDescendientes().size(); i++) {
                if (getDescendientes().get(i).getId() == id) {
                    borrarDescendiente(i);
                    anadirDescendiente(nodo,i);
                    return;
                } else {
                    for(int j=0; j<getDescendientes().size();j++){
                        getDescendientes().get(i).cruzar(nodo, id);
                    }
                }
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
    public int etiquetar(int x, HashMap<Integer,INodo> etiqueta) {
        this.id=x;
        etiqueta.put(x,this);
        if(getRaiz().equals("x")){
            return x+1;
        }

        INodo n1=getDescendientes().get(0);
        INodo n2=getDescendientes().get(1);
        return n2.etiquetar(n1.etiquetar(x+1,etiqueta),etiqueta);
    }

    public int getNNodos(){
        int x=0;
        if(getRaiz().equals("x")){
            return 1;
        }
        x++;
        List<INodo> aux=getDescendientes();
        for (INodo anAux : aux) {
            x += anAux.getNNodos();
        }
        return x;
    }

    @Override
    public INodo buscar(int id) {
        for(INodo n: getDescendientes()){
            if(n.getId()==id){
                return n;
            }
        }
        return null;
    }
}
