package p5.src;

import java.util.*;


public class GrafoNoDirigido<T> extends Grafo {

    @Override
    public void addArco(Vertice v1, Vertice v2, double peso) {
        aristas.put(v1.getId(),new HashMap<Integer,Double>().put(v2.getId(),peso));
        aristas.put(v2.getId(),new HashMap<Integer,Double>().put(v1.getId(),peso));
    }

    @Override
    public double getPesoDe(Vertice v1, Vertice v2) {
        Map<Integer, Double> aux;
        aux = (Map<Integer, Double>) aristas.get(v1.getId());
        return aux.get(v2.getId());
    }

    @Override
    public List<Vertice> getVecinosDe(Vertice v) {

        List<Vertice> ver= new ArrayList<>();
        Map<Integer, Double> aux;
        aux = (Map<Integer, Double>) aristas.get(v.getId());
        List<Integer> lista= new ArrayList<Integer>(aux.keySet());

        for(Integer i:lista){
            ver.add((Vertice) vertices.get(i));
        }
        return ver;
    }
}
