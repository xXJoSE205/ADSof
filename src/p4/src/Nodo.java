package p4.src;

import java.util.List;

public abstract class Nodo implements INodo{

    private String raiz;
    private String simbolo;
    private int id;

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

    public abstract void setDescendientes(List<INodo> descendientes);



    public int getId(){
        return id;
    }

    public INodo buscar(int id){
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 0");
        }
        List<INodo> aux=getDescendientes();
        for(INodo nodo:aux){
            if(nodo.getId()==id){
                return nodo;
            }
        }
        return null;
    }

    public void cruzar(INodo nodo, int id){
        if(nodo==null){
            throw new NullPointerException("El nodo es null");
        }
        if(id<1){
            throw new IllegalArgumentException("El id es menor que 1");
        }
        for(int i=0; i<getDescendientes().size();i++){
            if(getDescendientes().get(i).getId()==id){
                setDescendientes(nodo.getDescendientes());
                return;
            }
        }
        return;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void etiquetar() {
        int i=1;
        for(INodo nodo :getDescendientes()){
            nodo.setId(i);
            i++;
        }
    }
}
