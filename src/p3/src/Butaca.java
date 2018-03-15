/**
 * Esta clase contiene la información de una Butaca
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

public class Butaca {
    private int fila; /** Numero de la fila*/
    private int numero; /** Numero en la fila*/
    private boolean ocupada = false; /** Estado de la butaca, originalmente false(desocupada)*/

    /**
     * Constructor de Butaca
     *
     * @param fila Numero de la fila
     * @param numero Numero en la fila
     * @throws Error si alguno de los argumentos es menor que 1
     */
    public Butaca(int fila, int numero) {
        if(fila<1 || numero<1){
            throw new IllegalArgumentException("Fila o Numero menor que 1: "+fila+", "+numero);
        }
        this.fila = fila;
        this.numero = numero;
    }

    /**
     * Devuelve el numero de la fila de la Butaca
     *
     * @return Entero, numero de fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Devuelve el numero en la fila de la Butaca
     *
     * @return Entero, numero en la fila
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Devuelve el estado de la Butaca, si esta ocupada o no
     *
     * @return Boolean: true si esta ocupada, false en caso contrario
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * Cambia el estado de la butaca
     *
     * @param ocupada, true si se va a ocupar, false en caso contrario
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
