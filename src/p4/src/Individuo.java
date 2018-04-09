package p4.src;

import java.util.List;

public class Individuo implements IIndividuo{

    private INodo raiz;

    public INodo getExpresion() {
        return raiz;
    }

    public void setExpresion(INodo expresion) {
        this.raiz = expresion;
    }

    public double getFitness() {
        return 0;
    }

    public void setFitness(double fitness) {
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
