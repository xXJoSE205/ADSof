package p4.src;

import java.util.List;

/**
 * Esta clase contiene la informacion de la interfaz IIndividuo
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public interface IIndividuo {
    INodo getExpresion();
    void setExpresion(INodo expresion);
    double getFitness();
    void setFitness(double fitness);
    void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
    double calcularExpresion();
    int getNumeroNodos();
    void writeIndividuo();
    IIndividuo cruza(INodo nodo, int id);
    void etiquetaNodos();
    INodo buscar(int id);
}
