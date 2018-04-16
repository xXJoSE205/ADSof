package p4.src;

import java.util.List;

public class Individuo implements IIndividuo{

    private INodo raiz;
    private double fitness;
    private int Nnodos=-1;

    public INodo getExpresion() {
        return raiz;
    }

    public void setExpresion(INodo expresion) {
        this.raiz = expresion;
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setFitness(double fitness) {
        this.fitness=fitness;
    }

    public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {

    }

    public double calcularExpresion() {
        return raiz.calcular();
    }

    public int getNumeroNodos() {
        if(Nnodos==-1){
            setNnodos();
        }
        return this.Nnodos;
    }

    public void setNnodos(){
        this.Nnodos=getExpresion().getDescendientes().size();
    }
    public void writeIndividuo() {
        System.out.println("Expresion: " + raiz.toString());
    }

    public IIndividuo cruza(INodo nodo, int id){
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        INodo aux;
        IIndividuo nuevo= new Individuo();
        nuevo.setExpresion(getExpresion().copy());
        nuevo.getExpresion().cruzar(nodo, id);
        return nuevo;
    }

    public void etiquetaNodos(){
        getExpresion().etiquetar();
        }
}
