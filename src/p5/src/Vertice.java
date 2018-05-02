package p5.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertice<T> {
    private int id;
    private T datos;
    private static int contador=1;
    private static List<Integer> lista=new ArrayList<>();

    public Vertice(T datos) {
        for(Integer i: lista){
            if(i==contador){
                contador++;
            } else if(contador<i){
                break;
            }
        }
        id=contador;
        contador++;
        this.datos=datos;
    }

    public Vertice(int id, T datos){
        if (id<contador){
            return;
        }
        for(Integer i: lista){
            if(id==i){
                return;
            }
        }
        this.id = id;
        this.datos = datos;
        lista.add(id);
        Collections.sort(lista);
    }

    public int getId() {
        return id;
    }

    public T getDatos() {
        return datos;
    }

    @Override
    public String toString() {
        return datos.toString();
    }
}
