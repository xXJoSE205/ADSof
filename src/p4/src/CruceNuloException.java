package p4.src;

/**
 * Esta clase contiene la excepcion CruceNuloException
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class CruceNuloException extends Exception {
    /**
     * Constructor de la excepcion
     *
     * @param msg mensaje que se va a mostrar cuando salte la excepcion
     */
    public CruceNuloException (String msg){
        super(msg);
    }
}
