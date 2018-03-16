/**
 * Esta clase contiene la información de un Cine
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

import java.util.ArrayList;
import java.util.List;

public class Cine {
    /** Nombre del Cine*/
    private String nombre;
    /** Direccion del Cine*/
    private String direccion;
    /** Lista de Peliculas del Cine*/
    private List<Pelicula> peliculas;
    /** Lista de Salas del Cine*/
    private List<Sala> salas;
    /** Lista de Entradas vendidas del Cine*/
    private List<EntradaDiaEspectador> entradas;
    /** Recaudacion total del Cine*/
    private double recaudacion = 0;

    /**
     * Constructor de Cine, crea nuevas listas de Peliculas, Salas y Entradas
     *
     * @param nombre Nombre del Cine
     * @param direccion Direccion del cine
     * @throws IllegalArgumentException si algun argumento es nulo
     */
    public Cine(String nombre, String direccion) {
        if(nombre == null || direccion == null){
            throw new IllegalArgumentException("Nombre o direccion nula");
        }
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
     * @return boolean, true si se modifica el nombre correctamente
     * @throws IllegalArgumentException si el nombre es nulo
     */
    public boolean setNombre(String nombre) {
        if(nombre == null){
            throw new IllegalArgumentException("Nombre nulo");
        }
        this.nombre = nombre;
        return true;
    }

    /**
     * Añade una Sesion a una Sala
     *
     * @param sesion Sesion a añadir
     * @param sala Sala a la que añadir la Sesion
     * @return Boolean: true, si se añaden correctamente la Sala, false en caso contrario
     */
    public boolean anadirSalaSesion(Sala sala, Sesion sesion){
        if(sala==null || sesion==null){
            throw  new IllegalArgumentException("Sala o sesion nulo");
        }
        return sala.anadirSesion(sesion);
    }

    /**
     * Permite comprar una entrada para cierta sesion
     *
     * @param sesion sesion de la que se quiere comprar una entrada
     * @return boolean: true si se vende la entrada, false en caso contrario
     * @throws IllegalArgumentException si la sesion es nula, si la sesion no tiene sala asignada o si las butacas estan ocupadas
     * @throws IllegalAccessException si la sesion no esta asignada a una sala
     */
    public boolean ventaEntradas(Sesion sesion) throws IllegalAccessException {
        EntradaDiaEspectador e;

        if(sesion==null){
            throw new IllegalArgumentException("Sesion nula");
        }

        if(sesion.getSala()==null){
            throw new IllegalAccessException("Sesion sin sala asignada");
        }

        if (sesion.getButacasDisponibles() > 0) {
            for (Butaca butaca : sesion.getButacas()) {
                if (!butaca.isOcupada()) {
                    e = new EntradaDiaEspectador(sesion, butaca);
                    recaudacion = recaudacion + e.getPrecio();
                    butaca.setOcupada(true);
                    sesion.disminuirButacasDisponibles();
                    entradas.add(e);
                    System.out.println("Precio: " + e.getPrecio() + " Sala: " + e.getSesion().getSala() + " Fila: "
                            + e.getButaca().getFila() + " Numero: " + e.getButaca().getNumero());
                    return true;
                }
            }
        }
        throw new IllegalAccessException("Butacas de la sesion llenas");
    }

    /**
     * Quita una pelicula del cine junto a todas las sesiones en las que este
     *
     * @param pelicula pelicula que se quiere eliminar
     * @return int, numero de sesiones eliminadas si se ha borrado la pelicula, 0 si no existe esa pelicula
     * @throws IllegalArgumentException si la pelicula es nula
     */
    public int removePeliculaCartelera(Pelicula pelicula){
        int x=0;

        if(pelicula==null){
            throw new IllegalArgumentException("Pelicula nula");
        }

        if(peliculas.size()>0) {
            for (Pelicula pelicula1 : peliculas) {
                if (pelicula1.equals(pelicula)) {
                    for (Sala sala : salas) {
                        if (sala.getSesiones().size() > 0) {
                            for (Sesion ses : sala.getSesiones()) {
                                if (ses.getPelicula().equals(pelicula)) {
                                    x++;
                                    sala.getSesiones().remove(ses);
                                    break;
                                }
                            }
                        }
                    }
                    peliculas.remove(pelicula1);
                    break;
                }
            }
        }
        return x;
    }

    /**
     * Añade una sala al cine
     *
     * @param sala sala que se quiere añadir
     * @return boolean: true si se añade la sala
     * @throws IllegalArgumentException si la sala es nula
     */
    public boolean annadirSala(Sala sala){
        if(sala == null){
            throw new IllegalArgumentException("Sala nula");
        }
        salas.add(sala);
        return true;
    }

    /**
     * Añade una pelicula al cine
     *
     * @param pelicula pelicula que se quiere añadir
     * @return boolean: true si se añade la pelicula, false en caso contrario
     */
    public boolean anadirPelicula(Pelicula pelicula){
        if(pelicula==null){
            throw new IllegalArgumentException("Pelicula nula");
        }
        peliculas.add(pelicula);
        return true;
    }

}
