/**
 * Esta clase contiene la información de las sesiones
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sesion {
    private static final int MAX_FILA = 10; /** Maximo de filas en la sala*/
    private static final int MAX_COLUM = 20; /** Maximo de asientos por fila*/
    private LocalDateTime fecha; /** Fecha de la sesion*/
    private Pelicula pelicula; /** Pelicula de la sesion*/
    private Sala sala; /** Sala de la sesion*/
    private List<Butaca> butacas; /** Lista de butacas de la sala*/
    private int ButacasDisponibles = MAX_FILA*MAX_COLUM; /** Numero de butacas disponibles*/

    /**
     * Constructor de Sesion
     *
     * @param fecha fecha de la sesion
     * @param pelicula pelicula de la sesion
     */
    public Sesion(LocalDateTime fecha, Pelicula pelicula, Sala sala) {
        int i, j;
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = sala;
        this.butacas = new ArrayList<>();
        for(i=1; i<=MAX_FILA; i++){
            for(j=1; j<=MAX_COLUM; j++){
                Butaca b = new Butaca(i, j);
                butacas.add(b);
            }
        }
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
    /*public boolean anadirPelicula(Pelicula pelicula) {
        if(this.pelicula == pelicula){
            return false;
        }
        this.pelicula=pelicula;
        return true;
    }*/

    /**
     * Devuelve la sala de sesion
     * @return Sala: sala de la sesion
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Devuelve la lista de butacas
     *
     * @return List, lista de butacas de la sala
     */
    public List<Butaca> getButacas() {
        return butacas;
    }

    public int getButacasDisponibles() {
        return ButacasDisponibles;
    }

    public void disminuirButacasDisponibles() {
        if(this.ButacasDisponibles<0){
            throw new IllegalArgumentException("Numero de butacas disponibles menor que 0: "+ButacasDisponibles);
        }
        ButacasDisponibles -= 1;
    }
}
