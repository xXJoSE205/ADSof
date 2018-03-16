/**
 * Esta clase contiene la información de una Pelicula
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

public class Pelicula {
    /** Titulo*/
    private String titulo;
    /** Nombre del director*/
    private String director;
    /** Anno de estreno*/
    private int anno;
    /** Sinopsis*/
    private String sinopsis;
    /** Genero cinematografico*/
    private Genero genero;
    /** Duracion en minutos*/
    private int duracion;

    /**
     * Constructor de Pelicula
     *
     * @param titulo Titulo
     * @param director Nombre del director
     * @param anno Anno de estreno
     * @param sinopsis Sinopsis(trama)
     * @param genero Genero cinematografico
     * @param duracion Duracion en minutos de la pelicula
     * @throws IllegalArgumentException si el anno es menor que 1900 o si la duracion es menor que 1
     */
    public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero, int duracion) {
        if(anno<1900 || duracion<1){
            throw new IllegalArgumentException("Anno menor que 1900 o duracion menor que 1: "+anno+", "+duracion);
        }
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.duracion = duracion;
    }

    /**
     * Devuelve el titulo de la Pelicula
     *
     * @return Cadena con el titulo de la Pelicula
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el nombre del director de la Pelicula
     *
     * @return Cadena con el nombre del director de la Pelicula
     */
    public String getDirector() {
        return director;
    }

    /**
     * Devuelve el anno de estreno de la Pelicula
     *
     * @return Entero, anno de estreno de la Pelicula
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Devuelve la sinopsis de la Pelicula
     *
     * @return Cadena con la sinopsis de la Pelicula
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * Devuelve el genero de la Pelicula
     *
     * @return Genero, genero cinematografico de la Pelicula
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Devuelve la duracion de la Pelicula
     *
     * @return Entero, duracion de la pelicula en minutos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Muestra la informacion de la pelicula por pantalla
     */
    public void mostarInformacion() {
        System.out.println("Titulo: "+titulo+"\n"+"Director: "+director+"\n"+"Año: "+anno+"\n"+"Sinopsis: "+sinopsis+
                "\n"+"Genero: "+genero.toString()+"\n"+"Duracion: "+duracion+" min");
    }
}
