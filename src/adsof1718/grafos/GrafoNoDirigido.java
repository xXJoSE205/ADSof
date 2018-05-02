package adsof1718.grafos;

import java.util.*;

public class GrafoNoDirigido<T> extends Grafo<T> {

    @Override
    public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
        //Esta mierda no va
        if(existeArco(v1, v2) && existeArco(v2, v1)) {
            return;
        }

        if(aristas.get(v1.getId())!=null) {
            aristas.forEach((k, v) -> {
                if (k == v1.getId()) {
                    v.put(v2.getId(), peso);
                }
            });
        }else {
            Map<Integer, Double> arcos1 = new HashMap<>();
            arcos1.put(v2.getId(), peso);
            aristas.put(v1.getId(), arcos1);
        }

        if(aristas.get(v2.getId())!=null) {
            aristas.forEach((k, v) -> {
                if (k == v2.getId()) {
                    v.put(v1.getId(), peso);
                }
            });
        }else {
            Map<Integer, Double> arcos2 = new HashMap<>();
            arcos2.put(v1.getId(), peso);
            aristas.put(v2.getId(), arcos2);
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
