/**
 * Esta clase contiene la información de una Entrada
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

public abstract class Entrada {
    /** Constante, Precio fijo de una entrada*/
    private static final double PRECIO = 9.20;
    /** Precio de la entrada*/
    private double precio = PRECIO;
    /** Sesion de la sala*/
    private Sesion sesion;
    /**Butaca de la entrada*/
    private Butaca butaca;

    /**
     * Constructor de Entrada
     *
     * @param sesion sesion a la que pertenece
     * @param butaca la butaca de la entrada
     * @throws IllegalArgumentException si algun argumento es nulo
     */
    public Entrada(Sesion sesion, Butaca butaca) {
        if(sesion == null || butaca == null){
            throw new IllegalArgumentException("Sesion o butaca nula");
        }
        this.sesion = sesion;
        this.butaca = butaca;
        this.butaca.setOcupada(true);
    }

    /**
     * Devuelve el precion de entrada
     *
     * @return int con el precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve la sesion de la entrada
     *
     * @return Sesision, sesion de la entrada
     */
    public Sesion getSesion() {
        return sesion;
    }

    /**
     * Devuelve la butaca
     *
     * @return Butaca, la butaca de la entrada
     */
    public Butaca getButaca() {
        return butaca;
    }
}
