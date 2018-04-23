package p5.src;

public class Vertice<T> {
    private final int id;
    private T datos;
    private static int contador=1;

    public Vertice( T datos) {
        id=contador;
        contador++;
        this.datos=datos;
    }

    public int getId() {
        return id;
    }

    public T getDatos() {
        return datos;
    }
}
