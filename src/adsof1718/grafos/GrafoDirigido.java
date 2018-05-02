package adsof1718.grafos;

import java.util.*;

public class GrafoDirigido<T> extends Grafo<T> {

    @Override
    public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
        if(existeArco(v1, v2)) {
            return;
        }

        if(aristas.get(v1.getId())!=null) {
            aristas.forEach((k, v) -> {
                if (k == v1.getId()) {
                    v.put(v2.getId(), peso);
                }
            });
        }else {
            Map<Integer, Double> arcos = new HashMap<>();
            arcos.put(v2.getId(), peso);
            aristas.put(v1.getId(), arcos);
        }
    }

    @Override
    public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
        final double pArista[] = {0.0};
        if(existeArco(v1, v2)){
            aristas.forEach((key1, value1)->{
                if(key1==v1.getId()){
                    value1.forEach((key2, value2)->{
                        if(key2==v2.getId()){
                            pArista[0]= value2;
                        }
                    });
                }
            });
        }
        return pArista[0];
    }

    @Override
    public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
        List<Vertice<T>> ver = new ArrayList<>();
        aristas.forEach((key, value)->{
            if(key==v.getId()){
                value.forEach((key2, value2)-> ver.add(vertices.get(key2)));
            }
        });
        return ver;
    }
}
