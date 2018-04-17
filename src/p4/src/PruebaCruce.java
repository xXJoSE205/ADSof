package p4.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene el metodo para realizar el cruce
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class PruebaCruce {
    /**
     * Metodo que realiza el cruce entre 2 individuos
     * @param i1 Individuo numero 1 del cruce
     * @param i2 Individuo numero 2 del cruce
     * @return List, lista con los 2 nuevos individuos resultantes del cruce
     * @throws CruceNuloException Si los numeros aleatorios son iguales a 1 o iguales entre ellos
     */
    public List cruce(IIndividuo i1, IIndividuo i2) throws CruceNuloException {
        List<IIndividuo> lista = new ArrayList<>();
        int x= (int) Math.floor(Math.random()*i1.getNumeroNodos()+1);
        int y= (int) Math.floor(Math.random()*i2.getNumeroNodos()+1);
        if( y==x || x==1 || y==1){
            throw new CruceNuloException("Los 2 numeros son 1");
        }

        System.out.println("Punto de cruce del progenitor 1: "+x);
        System.out.println("Punto de cruce del progenitor 2: "+y);

        INodo busqueda1=i1.buscar(x);
        INodo busqueda2=i2.buscar(y);

        i1.cruza(busqueda2,x);
        i2.cruza(busqueda1,y);

        lista.add(i1);
        lista.add(i2);
        return lista;
    }

}
