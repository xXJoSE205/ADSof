package p4.src;

public class Terminal extends Nodo{
    public Terminal (String simbolo){
        super(simbolo);
    }

    public String toString() {
        return "" + super.getRaiz() + " ";
    }

    public double calcular() {
        return 3;
    }

    public INodo copy() {
        Terminal terminalCopy = new Terminal(this.getRaiz());
        return terminalCopy;
    }
}
