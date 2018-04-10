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

    public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
            String leido = buff.readLine();
            while(leido != null){
                StringTokenizer tok = new StringTokenizer(leido,"   ");
                numeros.put(Double.parseDouble(tok.nextToken()),Double.parseDouble(tok.nextToken()));
                leido = buff.readLine();
            }
            buff.close();
        } catch (FileNotFoundException fne){
            System.out.println(fne.getMessage());
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }


    }

    public double calcularFitness(IIndividuo individuo) {
        double fitness=0;
        for(double x : numeros.keySet()){
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
