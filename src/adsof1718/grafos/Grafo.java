package adsof1718.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Grafo<T> {
    protected Map<Integer, Vertice<T>> vertices = new HashMap<>();
    protected Map<Integer , Map<Integer, Double>> aristas = new HashMap<>();

    public Vertice<T> addVertice(T datos){
        Vertice<T> v = new Vertice<>(datos);
        vertices.put(v.getId(), v);
        return v;
    }

    public Vertice<T> addVertice(int id, T datos){
        Vertice<T> v = new Vertice<>(id, datos);
        vertices.put(id, v);
        return v;
    }

    public List<Vertice<T>> getVertices(){
        List<Vertice<T>> l = new ArrayList<>();
        vertices.forEach((k, v)->l.add(v));
        return l;
    }

    public int getNumVertices(){
        return vertices.size();
    }

    public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);

    public boolean existeArco(Vertice<T> v1, Vertice<T> v2){
        final Boolean b[] = {false};

        aristas.forEach((k, v)-> v.forEach((m, n) -> {
            if (k == v1.getId() && m == v2.getId()) {
                b[0] = true;
            }
        }));
        return b[0];
    }

    public int getNumArcos(){
        return aristas.size();
    }

    public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);

    public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
    // (en grafo dirigido, v ha de ser origen de los arcos)

    public String toString(){
        AtomicReference<String> cadena = new AtomicReference<>("");
        vertices.forEach((k, v)-> cadena.updateAndGet(v1 -> v1 + v + "  "));
        return String.valueOf(cadena);
    } // los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
}
