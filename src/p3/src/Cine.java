package p3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cine {
    private String nombre;
    private String direccion;
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<EntradaDiaEspectador> entradas;
    private double recaudacion;

    /*public Cine(String nombre, String direccion, List<Pelicula> peliculas, List<Sala> salas, List<Entrada> entradas, double recaudacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculas = new ArrayList<Pelicula>();
        this.salas = new ArrayList<Sesion>();
        this.entradas = new ArrayList<EntradaDiaEspectador>();
        this.recaudacion = recaudacion;
    }*/

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula crearPelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
        Pelicula p = new Pelicula(titulo, director, anno, sinopsis, genero);
        return p;
    }

    public boolean anadirPeliculaSala(Pelicula pelicula, Sesion sesion, Sala sala){
        sesion.anadirPelicula(pelicula);
        return sala.anadirSesion(sesion);
    }

    public boolean venderEntrada(Sesion sesion){
        double x;
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
