package p4.src;

import java.util.ArrayList;
import java.util.List;

public class TerminalAritmetico extends Terminal{

    public TerminalAritmetico (String simbolo){
        super(simbolo);
    }

    @Override
    public String toString() {
        return getRaiz()+" ";
    }

    @Override
    public INodo copy() {
        return new TerminalAritmetico(getRaiz());
    }

    @Override
    public void setDescendientes(List<INodo> descendientes) {

    }

    @Override
    public List<INodo> getDesNodo(){
        return new ArrayList<>();
    }

}
