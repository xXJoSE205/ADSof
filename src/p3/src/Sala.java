/**
 * Esta clase contiene la información de la sala
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int identificador; /** Identificador de la sala*/
    private List<Sesion> sesiones; /** Lista de sesiones de la sala*/

    /**
     * Constructor de sala
     *
     * @param identificador identificador de la sala
     * @throws {InvalidArgumentException}
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
     * @throws {InvalidArgumentException}
     */
    public boolean anadirSesion(Sesion sesion) {
        Pelicula peli;
        if(sesion == null){
            throw new IllegalArgumentException("Sesion nula");
        }
        for(Sesion ses: sesiones){
            peli = sesion.getPelicula();
            if(sesion.getFecha().compareTo(ses.getFecha())<0){
                if(ses.getFecha().compareTo(sesion.getFecha())>peli.getDuracion()){
                    return this.sesiones.add(sesion);
                }
                return false;
            }else{
                if(sesion.getFecha().compareTo(ses.getFecha())>peli.getDuracion()){
                    return this.sesiones.add(sesion);
                }
                return false;
            }
        }
        return false;
    }
}
