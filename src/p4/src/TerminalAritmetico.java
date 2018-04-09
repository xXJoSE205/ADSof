package p4.src;

public class TerminalAritmetico extends Terminal{

    public TerminalAritmetico (String simbolo){
        super(simbolo);
    }

    @Override
    public String toString() {
        return getRaiz()+" ";
    }

    @Override
    public double calcular() {
        return 0;
    }

    @Override
    public INodo copy() {
        return new TerminalAritmetico(getRaiz());
    }
}
