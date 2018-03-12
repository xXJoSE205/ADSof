/**
 * Esta clase contiene la información de un Cine
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega *
 */
package p3.src;

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
     * @param nombre Cadena con el nuevo nombre del Cine
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Anade una Pelicula a una Sesion y a una Sala
     * @param pelicula Pelicula a anadir
     * @param sesion Sesion a la que anadir la Pelicua
     * @param sala Sala a la que anadir la Sesion
     * @return Boolean: true, si se anaden correctamente la Pelicula y la Sala, false en caso contrario
     */
    public boolean anadirPeliculaSala(Pelicula pelicula, Sesion sesion, Sala sala){
        return sesion.anadirPelicula(pelicula) && sala.anadirSesion(sesion);
    }

    public boolean venderEntrada(Sesion sesion){
        List<Entrada> entradasSesion= new ArrayList<>();
        for(Entrada entrada : entradas){
            if(sesion == entrada.getSesion()){
                entradasSesion.add(entrada);
            }
        }
        for(Entrada entrada : entradasSesion){
            if(!entrada.getButaca().isOcupada()){

                recaudacion=recaudacion+entrada.getPrecio();
                System.out.println("Precio"+ entrada.getPrecio() + "Fila" + entrada.getButaca().getFila()+ "numero" +entrada.getButaca().getNumero());
                entrada.getButaca().setOcupada(true);
                return true;
            }
        }
        return false;
    }
}
