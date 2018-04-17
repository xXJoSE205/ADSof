package p4.src;

import java.util.HashMap;
import java.util.List;

/**
 * Esta clase contiene la informacion de un Individuo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class Individuo implements IIndividuo{
    /** Raiz del arbol de nodos*/
    private INodo raiz;
    /** Fitness*/
    private double fitness;
    /** Numero de nodos en el individuo*/
    private int nNodos=-1;

    private HashMap<Integer,INodo>ids= new HashMap<>();

    /**
     * Obtiene la expresion, raiz, del individup
     *
     * @return Nodo raiz del individuo
     */
    public INodo getExpresion() {
        return raiz;
    }

    /**
     * Establece la expresion, raiz, del individuo
     *
     * @param expresion Nodo raiz a establecer
     */
    public void setExpresion(INodo expresion) {
        this.raiz = expresion;
    }

    /**
     * Devuelve el fitnes del individuo
     *
     * @return double, fitness del individuo
     */
    public double getFitness() {
        return this.fitness;
    }

    /**
     * Establece el fitness del individuo
     *
     * @param fitness double a establecer
     */
    public void setFitness(double fitness) {
        this.fitness=fitness;
    }

    public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {

    }

    /**
     * Calcula la expresion total del individuo
     *
     * @return double, resultado del individuo
     */
    public double calcularExpresion() {
        return raiz.calcular();
    }

    /**
     * Devuelve el numero de nodos del individuo
     *
     * @return entero, numero de nodos
     */
    public int getNumeroNodos() {
        if(nNodos==-1){
            setNnodos();
        }
        return this.nNodos;
    }

    /**
     * Estable el numero de nodos del individuo como el tamaño de la lista de descendientes
     */
    public void setNnodos(){
        int x=1;

        for(INodo nodos: getExpresion().getDescendientes()){
            x+=nodos.getNNodos();
        }
        this.nNodos=x;
    }

    /**
     * Escribe por pantalla la expresion del individuo
     */
    public void writeIndividuo() {
        System.out.println("Expresion: " + raiz.toString());
    }

    /**
     * Crea un nuevo individuo resultante del cruce
     *
     * @param nodo Nodo a cruzar
     * @param id ID del nodo donde hay que realizar el cruce
     * @return IIndividuo resultante del cruce
     */
    public IIndividuo cruza(INodo nodo, int id){
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        getExpresion().cruzar(nodo,id);
        return this;
    }

    /**
     * Establece un ID a todos los nodos por orden de profundidad
     */
    public void etiquetaNodos(){
        raiz.etiquetar(1,ids);
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
        return ids.get(id);
    }
}
