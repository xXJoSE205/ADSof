package p4.src;

import java.util.List;

public abstract class Nodo implements INodo{

    private String raiz;
    private int id;
    private static int contador = 1;
    private String simbolo;

    public Nodo(String simbolo){
        this.simbolo = simbolo;
    }

    public String getRaiz() {
        return simbolo;
    }

    public abstract List<INodo> getDescendientes();

    public abstract void incluirDescendiente(INodo nodo);

    public abstract double calcular();

    public abstract INodo copy();
    public INodo copy() {
        return null;
    }

    public void etiquetar(Nodo nodo){
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }

        while(!nodo.getDescendientes().isEmpty()){
            nodo.getDescendientes().get(0).etiquetar(nodo.getDescendientes().get(0));
            nodo.id=contador;
            contador = contador + 1;
            nodo.getDescendientes().get(1).etiquetar(nodo.getDescendientes().get(1));
        }
        return;
    }

}
