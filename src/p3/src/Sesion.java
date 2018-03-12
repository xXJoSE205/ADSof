/**
 * Esta clase contiene la información de las sesiones
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime fecha; /** Fecha de la sesion*/
    private Pelicula pelicula; /** Pelicula de la sesion*/
    private Sala sala; /** Sala de la sesion*/

    /**
     * Constructor de Sesion
     *
     * @param fecha fecha de la sesion
     * @param pelicula pelicula de la sesion
     */
    public Sesion(LocalDateTime fecha, Pelicula pelicula) {
        this.fecha = fecha;
        this.pelicula = pelicula;
    }

    /**
     * Devuelve la fecha de la sesion
     *
     * @return LocalDateTime, fecha de la sesion
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Añade la fecha a la sesion
     *
     * @param fecha fecha a añadir
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la pelicula de la sesion
     *
     * @return Pelicula, pelicula de la sesion
     */
    public Pelicula getPelicula() {
        return pelicula;
    }


    /**
     * Añade una pelicula a la sesion
     *
     * @param pelicula pelicula que hay que añadir a la sesion
     * @return boolean: true si se añade la pelicula, false en caso contrario
     */
    public boolean anadirPelicula(Pelicula pelicula) {
        if(this.pelicula == pelicula){
            return false;
        }
        this.pelicula=pelicula;
        return true;
    }
}
