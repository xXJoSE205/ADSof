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
    private List<Butaca> butacas; /** Lista de butacas de la sala*/
    private List<Sesion> sesiones; /**Lista de sesiones de la sala*/

    /**
     * Constructor de sala
     * @param identificador identificador de la sala
     */
    public Sala(int identificador) {
        this.identificador = identificador;
        this.butacas = new ArrayList<Butaca>();
        this.sesiones = new ArrayList<Sesion>();
    }

    /**
     * Devuelve el identificador de la sala
     * @return int, identificador de la sala
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Devuelve la lista de butacas
     * @return List, lista de butacas de la sala
     */
    public List<Butaca> getButacas() {
        return butacas;
    }

    /**
     * Devuelve la lista de sesiones
     * @return List, lista de sesiones de la sala
     */
    public List<Sesion> getSesiones() {
        return sesiones;
    }

    /**
     * Añade una sesion a la sala
     * @param sesion sesion que tiene que añadir a la lista
     * @return boolean: true si se añade la sesion, false en caso contrario
     */
    public boolean anadirSesion(Sesion sesion) {
        for(Sesion x: sesiones){
            if(x.getFecha().isEqual(sesion.getFecha())){
                return false;
            }
        }
        return this.sesiones.add(sesion);
    }

    /**
     * Añade una butaca a la sala
     * @param butaca butaca que tiene que añadir a la lista
     * @return boolean: true si se añade la sesion, false en caso contrario
     */
    public boolean anadirButaca(Butaca butaca) {
        for(Butaca x: butacas){
            if(x.getFila()== butaca.getFila()){
                if(x.getNumero()== butaca.getNumero()) {
                    return false;
                }
            }
        }
        return this.butacas.add(butaca);
    }
}
