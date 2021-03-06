package p4.src;

import java.io.*;
import java.util.List;
import java.util.TreeMap;

/**
 * Esta clase contiene la informacion de un DominioAritmetico
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class DominioAritmetico implements IDominio {
    /** Arbol con los operandos*/
    private TreeMap<Double, Double> numeros;

    /** Constructor de DominioAritmetico*/
    public DominioAritmetico() {
        this.numeros = new TreeMap<>();
    }

    public List<Terminal> definirConjuntoTerminales(String... terminales) {
        return null;
    }

    public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
            throws ArgsDistintosFuncionesException {
        return null;
    }

    /**
     * Establece los valores con los que se va ha realizar la expresion
     *
     * @param ficheroDatos fichero que contiene los valores de la prueba
     */
    public void definirValoresPrueba(String ficheroDatos){
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
            String linea, split[];
            while ((linea = buffer.readLine()) != null) {
                split = linea.split("\\s+");
                numeros.put(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            }
            buffer.close();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Calcula el fitness de un individuo
     * @param individuo individuo del que se quiere calcular el fitness
     * @return double, el fitness del individuo
     */
    public double calcularFitness(IIndividuo individuo) {
        double fitness=0;
        for(double x : numeros.keySet()){
            Terminal.setValor(x);
            double y = individuo.calcularExpresion();
            System.out.println("Valor "+ x + " <->  Rdo estimado: "+ y + " <-> Rdo real: " + numeros.get(x) );
            if(numeros.get(x)==y || numeros.get(x)== y+1 || numeros.get(x)==y-1){
                fitness++;
            }
        }
        individuo.setFitness(fitness);

        return fitness;
    }
}
