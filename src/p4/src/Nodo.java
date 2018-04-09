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

    public void etiquetar(){
        while(!getDescendientes().isEmpty()){
            for(int i=0; i<getDescendientes().size();i++){
                if(getDescendientes().size()/2==i){
                    id=contador;
                    contador = contador +1;
                }
                getDescendientes().get(i).etiquetar();

            }
            id=contador;
            contador = contador + 1;
        }
    }

}
