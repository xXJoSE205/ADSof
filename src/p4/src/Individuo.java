package p4.src;

import java.util.List;

public class Individuo implements IIndividuo{

    private INodo raiz;
    private double fitness;

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
        return raiz.getDescendientes().size();
    }

    public void writeIndividuo() {
        System.out.println("Expresion: " + raiz.toString());
    }
}
