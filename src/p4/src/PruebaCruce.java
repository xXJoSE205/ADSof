package p4.src;

import java.util.ArrayList;
import java.util.List;


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
        INodo nodo;
        int x= (int) (Math.random()*i1.getNumeroNodos());
        int y= (int) (Math.random()*i2.getNumeroNodos());
        if( y==x || x==1 || y==1){
            throw new CruceNuloException("Los 2 numeros son 1");
        }
        nodo=i1.getExpresion();
        INodo busqueda1=nodo.buscar(x);
        nodo=i2.getExpresion();
        INodo busqueda2=nodo.buscar(y);

        i1.cruza(busqueda2,x);
        i2.cruza(busqueda1,y);

        lista.add(i1);
        lista.add(i2);
        return lista;
    }

}
