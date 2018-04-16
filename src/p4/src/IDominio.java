/**
 * Esta clase contiene la informacion de la interfaz IDominio
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

import java.io.*;
import java.util.List;

public interface IDominio {
    List<Terminal> definirConjuntoTerminales(String... terminales);
    List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
            throws ArgsDistintosFuncionesException;
    void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
    double calcularFitness(IIndividuo individuo);
}
