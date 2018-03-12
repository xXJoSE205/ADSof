package p3.src;

public class Butaca {
    private int fila;
    private int numero;
    private boolean ocupada;

    public Butaca(int fila, int numero, boolean ocupada) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = ocupada;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
