/**
 * Esta clase contiene la excepcion ArgsDistintosFuncionesException
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

public class ArgsDistintosFuncionesException extends Exception{
    /**
     * Constructor de la excepcion
     *
     * @param msg mensaje que se va a mostrar cuando salte la excepcion
     */
    public ArgsDistintosFuncionesException(String msg) {
        super(msg);
    }
}
