package p3.src;

public abstract class Entrada {
    private double precio = 9.20;
    private Sesion sesion;
    private Butaca butaca;

    public Entrada(Sesion sesion, Butaca butaca) {
        this.sesion = sesion;
        this.butaca = butaca;
        this.butaca.setOcupada(true);
    }

    public double getPrecio() {
        return precio;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public Butaca getButaca() {
        return butaca;
    }
}
