/**
 * Esta clase contiene la información de la sala
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    /** Identificador de la sala*/
    private int identificador;
    /** Lista de sesiones de la sala*/
    private List<Sesion> sesiones;

    /**
     * Constructor de sala
     *
     * @param identificador identificador de la sala
     * @throws IllegalArgumentException si el identificador es menor que 1
     */
    public Sala(int identificador) {
        if(identificador<1){
            throw new IllegalArgumentException("Identificador menor que 1: "+identificador);
        }
        this.identificador = identificador;
        this.sesiones = new ArrayList<>();

    }

    /**
     * Devuelve el identificador de la sala
     *
     * @return int, identificador de la sala
     */
    public int getIdentificador() {
        return identificador;
    }


    /**
     * Devuelve la lista de sesiones
     *
     * @return List, lista de sesiones de la sala
     */
    public List<Sesion> getSesiones() {
        return sesiones;
    }

    /**
     * Añade una sesion a la sala
     *
     * @param sesion sesion que se quiere que añadir a la lista
     * @return boolean: true si se añade la sesion, false en caso contrario
     * @throws IllegalArgumentException si la sesion es nula o si ya hay una pelicula a la misma hora
     */
    public boolean anadirSesion(Sesion sesion) {
        Pelicula peli;
        if(sesion == null){
            throw new IllegalArgumentException("Sesion nula");
        }
        if(sesiones.size()==0){
            sesion.setSala(this);
            return sesiones.add(sesion);
        }
        for(Sesion ses: sesiones){
            peli = sesion.getPelicula();
            if(sesion.getFecha().compareTo(ses.getFecha())<0){
                if(ses.getFecha().compareTo(sesion.getFecha())>peli.getDuracion()){
                    sesion.setSala(this);
                    return this.sesiones.add(sesion);
                }
                throw new IllegalArgumentException("Ya hay una pelicula a la misma hora");
            }else{
                if(sesion.getFecha().compareTo(ses.getFecha())>peli.getDuracion()){
                    sesion.setSala(this);
                    return this.sesiones.add(sesion);
                }
                throw new IllegalArgumentException("Ya hay una pelicula a la misma hora");
            }
        }
        return false;
    }
}
