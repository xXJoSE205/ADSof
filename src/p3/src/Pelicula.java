/**
 * Esta clase contiene la información de una Pelicula
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 *
 */
package p3.src;

public class Pelicula {
    private String titulo; /** Titulo*/
    private String director; /** Nombre del director*/
    private int anno; /** Anno de estreno*/
    private String sinopsis; /** Sinopsis*/
    private Genero genero; /** Genero cinematografico*/

    /**
     * Constructor de Pelicula
     *
     * @param titulo Titulo
     * @param director Nombre del director
     * @param anno Anno de estreno
     * @param sinopsis Sinopsis(trama)
     * @param genero Genero cinematografico
     */
    public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero) {
        this.titulo = titulo;
        this.director = director;
        this.anno = anno;
        this.sinopsis = sinopsis;
        this.genero = genero;
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
     * Muestra la informacion de la pelicula por pantalla
     */
    public void mostarInformacion() {
        System.out.println("Titulo: "+titulo+"\n"+"Director: "+director+"\n"+"Año: "+anno+"\n"+"Sinopsis: "+sinopsis+"\n"+"Genero: "+genero+"\n");
    }
}
