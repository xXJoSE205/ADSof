/**
 * Esta clase contiene la información de un Cine
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cine {
    private String nombre; /** Nombre del Cine*/
    private String direccion; /** Direccion del Cine*/
    private List<Pelicula> peliculas; /** Lista de Peliculas del Cine*/
    private List<Sala> salas; /** Lista de Salas del Cine*/
    private List<EntradaDiaEspectador> entradas; /** Lista de Entradas vendidas del Cine*/
    private double recaudacion = 0; /** Recaudacion total del Cine*/

    /**
     * Constructor de Cine, crea nuevas listas de Peliculas, Salas y Entradas
     *
     * @param nombre Nombre del Cine
     * @param direccion Direccion del cine
     */
    public Cine(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculas = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
    }

    /**
     * Devuelve el nombre del Cine
     *
     * @return Cadena con el nombre del Cine
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la direccion del Cine
     *
     * @return Cadena con la direccion del Cine
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Devuelve la lista de Peliculas del Cine
     *
     * @return List con las Peliculas del Cine
     */
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * Devuelve la lista de Salas del Cine
     *
     * @return List con las Salas del Cine
     */
    public List<Sala> getSalas() {
        return salas;
    }

    /**
     * Devuelve la lista de Entradas del Cine
     *
     * @return List con las Entradas del Cine
     */
    public List<EntradaDiaEspectador> getEntradas() {
        return entradas;
    }

    /**
     * Devuelve la recaudacion total del Cine
     *
     * @return Double con la recaudacion total del Cine
     */
    public double getRecaudacion() {
        return recaudacion;
    }

    /**
     * Cambia el nombre del Cine
     *
     * @param nombre Cadena con el nuevo nombre del Cine
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Añade una Pelicula a una Sesion y a una Sala
     *
     * @param pelicula Pelicula a añadir
     * @param sesion Sesion a la que añadir la Pelicua
     * @param sala Sala a la que añadir la Sesion
     * @return Boolean: true, si se añaden correctamente la Pelicula y la Sala, false en caso contrario
     */
    public boolean anadirPeliculaSala(Pelicula pelicula, Sesion sesion, Sala sala, LocalDateTime fecha){
        Sesion s = new Sesion(fecha, pelicula, sala);
        return sala.anadirSesion(s);
    }


    /**
     * Permite comprar una entrada para cierta sesion
     *
     * @param sesion sesion de la que se quiere comprar una entrada
     * @return boolean: true si se añade la sesion, false en caso contrario
     */
    public boolean venderEntrada(Sesion sesion){
        EntradaDiaEspectador e;

        if(sesion.getButacasDisponibles()>0) {
            for (Butaca butaca : sesion.getButacas()) {
                if (!butaca.isOcupada()) {
                    e = new EntradaDiaEspectador(sesion, butaca);
                    recaudacion = recaudacion + e.getPrecio();
                    butaca.setOcupada(true);
                    sesion.disminuirButacasDisponibles();
                    entradas.add(e);
                    System.out.println("Precio: " + e.getPrecio() + "Sala: " + e.getSesion().getSala() + " Fila: " + e.getButaca().getFila() + "Numero: " + e.getButaca().getNumero());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param pelicula pelicula que se quiere eliminar
     * @return boolean true si se ha borrado la pelicula, false en caso de error o que la pelicula no se encuentre
     */
    public boolean removePelicula(Pelicula pelicula){
        int x=0;
        for(Pelicula pelicula1 : peliculas){
            if( pelicula1 == pelicula){
                for(Sala sala : salas){
                    for(Sesion sesion : sala.getSesiones()){
                        if(sesion.getPelicula() == pelicula){
                            x=x+1;
                            salas.remove(sesion);
                        }
                    }
                }
                peliculas.remove(pelicula);
            }
            return true;
        }
        return false;
    }
}
