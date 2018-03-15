/**
 * Esta clase contiene la información de una Entrada
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

public abstract class Entrada {
    private static final double PRECIO = 9.20;
    private double precio = PRECIO; /** Precio de la entrada*/
    private Sesion sesion; /** Sesion de la sala*/
    private Butaca butaca; /**Butaca de la entrada*/

    /**
     * Constructor de Entrada
     *
     * @param sesion sesion a la que pertenece
     * @param butaca la butaca de la entrada
     */
    public Entrada(Sesion sesion, Butaca butaca) {
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
