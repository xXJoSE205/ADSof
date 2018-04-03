package p4.src;

import java.util.List;

public interface IIndividuo {
    INodo getExpresion();
    void setExpresion(INodo expresion);
    double getFitness();
    void setFitness(double fitness);
    void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
    double calcularExpresion();
    int getNumeroNodos();
    void writeIndividuo();
}
