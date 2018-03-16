/**
 * Esta clase contiene una enumeracion de los generos cinematograficos
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

public enum Genero {
    /** Genero de accion*/
    ACCION(1),
    /** Genero de ciencia ficcion*/
    CIENCIA_FICCION(2),
    /** Genero de drama*/
    DRAMA(3),
    /** Genero de comedia*/
    COMEDIA(4),
    /** Genero de fantasia*/
    FANTASIA(5),
    /** Genero de terror*/
    TERROR(6),
    /** Genero de romance*/
    ROMANCE(7),
    /** Genero musical*/
    MUSICAL(8),
    /** Genero de suspense*/
    SUSPENSE(9);

    Genero(int genero) {
    }
}
