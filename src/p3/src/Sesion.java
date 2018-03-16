/**
 * Esta clase contiene la información de las sesiones
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sesion {
    /** Maximo de filas en la sala*/
    public static final int MAX_FILA = 10;
    /** Maximo de asientos por fila*/
    public static final int MAX_COLUM = 20;
    /** Fecha de la sesion*/
    private LocalDateTime fecha;
    /** Pelicula de la sesion*/
    private Pelicula pelicula;
    /** Sala de la sesion*/
    private Sala sala;
    /** Lista de butacas de la sala*/
    private List<Butaca> butacas;
    /** Numero de butacas disponibles*/
    private int butacasDisponibles = MAX_FILA*MAX_COLUM;

    /**
     * Constructor de Sesion
     *
     * @param fecha fecha de la sesion
     * @param pelicula pelicula de la sesion
     * @throws IllegalArgumentException si algun argumento es nulo
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
     * @throws IllegalArgumentException si la fecha es nula
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
     * @return boolean, true si se modifica correctamente
     * @throws IllegalArgumentException si la sala es nula
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
     * @throws IllegalArgumentException si el numero de butacas disponibles es menor que 1
     */
    public boolean disminuirButacasDisponibles() {
        if(this.butacasDisponibles<1){
            throw new IllegalArgumentException("Numero de butacas disponibles menor que 1: "+butacasDisponibles);
        }
        butacasDisponibles -= 1;
        return true;
    }
}
