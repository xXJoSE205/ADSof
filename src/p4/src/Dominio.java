package p4.src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Dominio implements IDominio {

    public DominioAritmetico() {
    }

    public List<Terminal> definirConjuntoTerminales(String... terminales) {
        return null;
    }

    public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
            throws ArgsDistintosFuncionesException {
        return null;
    }

    public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {

    }

    public double calcularFitness(IIndividuo individuo) {
        return 0;
    }
}
