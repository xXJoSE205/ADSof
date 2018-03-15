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
    public static final int MAX_FILA = 10; /** Maximo de filas en la sala*/
    public static final int MAX_COLUM = 20; /** Maximo de asientos por fila*/
    private LocalDateTime fecha; /** Fecha de la sesion*/
    private Pelicula pelicula; /** Pelicula de la sesion*/
    private Sala sala; /** Sala de la sesion*/
    private List<Butaca> butacas; /** Lista de butacas de la sala*/
    private int butacasDisponibles = MAX_FILA*MAX_COLUM; /** Numero de butacas disponibles*/

    /**
     * Constructor de Sesion
     *
     * @param fecha fecha de la sesion
     * @param pelicula pelicula de la sesion
     * @throws Error si algun argumento es nulo
     */
    public Sesion(LocalDateTime fecha, Pelicula pelicula) {
        int i, j;
        if(fecha == null || pelicula == null) {
            throw new IllegalArgumentException("Fecha o pelicula nula");
        }
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = null;
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
     * Modifica la fecha a la sesion
     *
     * @param fecha fecha por la cual se quiere modificar
     * @return boolean, true si se ha añadido la fecha correctamente
     * @throws {InvalidArgumentException}
     */
    public boolean setFecha(LocalDateTime fecha) {
        if(fecha == null){
            throw new IllegalArgumentException("Fecha nula");
        }
        this.fecha = fecha;
        return true;
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
     * Devuelve la sala de sesion
     *
     * @return Sala, sala de la sesion
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Modifica la sala de la sesion
     *
     * @param sala Sala en la que se integra la sesion
     * @throws {InvalidArgumentException}
     */
    public boolean setSala(Sala sala){
        if(sala == null){
            throw new IllegalArgumentException("Puntero de sala nula");
        }
        this.sala = sala;
        return true;
    }

    /**
     * Devuelve la lista de butacas
     *
     * @return List, lista de butacas de la sala
     */
    public List<Butaca> getButacas() {
        return butacas;
    }

    /**
     * Devuelve el numero de butacas disponibles
     *
     * @return Entero, numero de butacas disponibles
     */
    public int getButacasDisponibles() {
        return butacasDisponibles;
    }

    /**
     * Disminuye el numero de butacas disponibles
     *
     * @return boolean, true si se ha disminuido el numor correctamente
     * @throws Error si el numero de butacas disponibles es menor que 1
     */
    public boolean disminuirButacasDisponibles() throws IllegalAccessException {
        if(this.butacasDisponibles<1){
            throw new IllegalArgumentException("Numero de butacas disponibles menor que 1: "+butacasDisponibles);
        }
        butacasDisponibles -= 1;
        return true;
    }
}
