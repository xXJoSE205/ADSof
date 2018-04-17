
package p4.src;

import java.io.*;
import java.util.List;
/**
 * Esta clase contiene la informacion de la interfaz IDominio
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public interface IDominio {
    List<Terminal> definirConjuntoTerminales(String... terminales);
    List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
            throws ArgsDistintosFuncionesException;
    void definirValoresPrueba(String ficheroDatos) throws IOException;
    double calcularFitness(IIndividuo individuo);
}
