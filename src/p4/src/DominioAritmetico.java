/**
 * Esta clase contiene la informacion de un DominioAritmetico
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DominioAritmetico implements IDominio {
    private TreeMap<Double, Double> numeros;

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
