/**
 * Esta clase contiene el test de la clase Cine
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.pruebas;

import org.junit.Before;
import org.junit.Test;
import p3.src.*;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CineTest {
    /**Cine general para el test*/
    private Cine cine;

    /**
     * Crea un cine para realizar los test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        cine = new Cine("J & M","Calle bronce numero 5");
    }

    /**
     * Test 1 del constructor, se espera un IllegalArgumentException.
     * El nombre es NULL
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor1(){
        System.out.println("Cine: Prueba constructor1");
        Cine cine2 = new Cine(null, "Calle Bronce, N 5");
    }

    /**
     * Test 2 del constructor, se espera un IllegalArgumentException.
     * La direccion es NULL.
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor2(){
        System.out.println("Cine: Prueba constructor2");
        Cine cine2 = new Cine("J & M", null);
    }

    /**
     * Test 3 del constructor, se espera un IllegalArgumentException.
     * El nombre y la direccion son NULL.
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor3(){
        System.out.println("Cine: Prueba constructor3");
        Cine cine2 = new Cine(null, null);
    }

    /**
     * Test de getNombre, se comprueba que el nombre del setUp es igual a "J & M"
     */
    @Test
    public void getNombre() {
        System.out.println("Cine: Prueba getNombre");
        assertTrue(cine.getNombre().equals("J & M"));
    }

    /**
     * Test de getDireccion, se comprueba que el nombre del setUp es igual a "Calle bronce numero 5".
     */
    @Test
    public void getDireccion() {
        System.out.println("Cine: Prueba getDireccion");
        assertTrue(cine.getDireccion().equals("Calle bronce numero 5"));
    }

    /**
     * Test de getPelicula, se comprueba que la lista de peliculas del setUp es distinta de NULL
     */
    @Test
    public void getPeliculas() {
        System.out.println("Cine: Prueba getPeliculas");
        Pelicula p1= new Pelicula("Dragonball Evolution","James Wong",2009,
                "Cuenta la epica aventura de un joven que descubre su destino: "
                + "salvar al mundo de las fuerzas malvadas", Genero.FANTASIA, 90);
        cine.anadirPelicula(p1);
        assertNotNull(cine.getPeliculas());
    }

    /**
     * Test de getSalas, se comprueba que la lista de salas del setUp es distinta de NULL
     */
    @Test
    public void getSalas() {
        System.out.println("Cine: Prueba getSalas");
        Sala s= new Sala(7);
        cine.annadirSala(s);
        assertNotNull(cine.getSalas());
    }

    /**
     * Test de getEntradas, se comprueba que la lista de entradas del setUp es distinta de NULL
     */
    @Test
    public void getEntradas() throws IllegalAccessException {
        System.out.println("Cine: Prueba getEntradas");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        cine.ventaEntradas(sesion);
        assertNotNull(cine.getSalas());
    }

    /**
     * Test de getRecaudacion, se comprueba que la recaudacion setUp es 9,20
     */
    @Test
    public void getRecaudacion() throws IllegalAccessException {
        System.out.println("Cine: Prueba getRecaudacion");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        cine.ventaEntradas(sesion);
        assertTrue(cine.getRecaudacion()==9.20);
    }

    /**
     * Test 1 de setNombre, se le pasa un nombre, se espera un true
     */
    @Test
    public void setNombre1() {
        System.out.println("Cine: Prueba setNombre1");
        assertTrue(cine.setNombre("Zero Two"));
    }

    /**
     * Test 2 de setNombre, se espera un IllegalArgumentException.
     * El nombre es NULL
     */
    @Test(expected = IllegalArgumentException.class)
    public void setNombre2() {
        System.out.println("Cine: Prueba setNombre2");
        cine.setNombre(null);
    }

    /**
     * Test 1 de ventaEntradas, se comprueba que al vender una entrada devuelva true
     */
    @Test
    public void ventaEntradas1() throws IllegalAccessException {
        System.out.println("Cine: Prueba ventaEntradas1");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos", Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        assertTrue(cine.ventaEntradas(sesion));
    }

    /**
     *  Test 2 de ventaEntradas, se espera un IllegalArgumentException.
     *  La sesion es NULL
     */

    @Test(expected = IllegalArgumentException.class)
    public void ventaEntradas2() throws IllegalAccessException {
        System.out.println("Cine: Prueba ventaEntradas2");
        cine.ventaEntradas(null);
    }

    /**
     * Test 3 de ventaEntradas, se espera un IllegalAccessException.
     * La sesion no tiene una sala asignada
     */
    @Test(expected = IllegalAccessException.class)
    public void ventaEntradas3() throws IllegalAccessException {
        System.out.println("Cine: Prueba ventaEntradas3");
        Pelicula p1 = new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos", Genero.ACCION, 90);
        Sesion ses = new Sesion(LocalDateTime.of(2018, 3, 16, 15, 00), p1);
        cine.ventaEntradas(ses);
    }

    /**
     * Test de removePelicula, comprueba que el metodo devuelve 1
     */
    @Test
    public void removePeliculaCartelera1() {
        System.out.println("Cine: Prueba removePeliculaCartelera1");
        Sala sala = new Sala(7);
        Pelicula p1 = new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos", Genero.ACCION, 90);
        Sesion sesion = new Sesion(LocalDateTime.of(2018,12,03,15,20), p1);
        cine.annadirSala(sala);
        cine.anadirPelicula(p1);
        sala.anadirSesion(sesion);
        assertTrue(cine.removePeliculaCartelera(p1)>0);
    }

    /**
     * Test 2 de removePelicula, se espera un IllegalArgumentException.
     *  La pelicula es NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void removePeliculaCartelera2() {
        System.out.println("Cine: Prueba removePeliculaCartelera1");
        cine.removePeliculaCartelera(null);
    }

    /**
     * Test 1 de annadirSala, se espera un true
     */
    @Test
    public void annadirSala1(){
        System.out.println("Cine: Prueba annadirSala1");
        Sala sala= new Sala(7);
        assertTrue(cine.annadirSala(sala));
    }

    /**
     * Test 2 de annadirSala, se espera un IllegalArgumentException.
     *  La sala es NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void annadirSala2(){
        System.out.println("Cine: Prueba annadirSala2");
        cine.annadirSala(null);
    }

    /**
     * Test 1 de anadirPelicula, se espera un true.
     */
    @Test
    public void anadirPelicula1(){
        System.out.println("Cine: Prueba anadirPelicula1");
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        assertTrue(cine.anadirPelicula(p1));
    }

    /**
     * Test 2 de anadirPelicula, se espera un IllegalArgumentException.
     *  La pelicula es NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void anadirPelicula2() {
        System.out.println("Cine: Prueba anadirPelicula2");
        cine.anadirPelicula(null);
    }

    /**
     * Test 1 de anadirSalaSesion, se espera un true
     */
    @Test
    public void anadirSalaSesion1(){
        System.out.println("Cine: Prueba anadirSalaSesion1");
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        Sala sala= new Sala(7);
        assertTrue(cine.anadirSalaSesion(sala, sesion));
    }

    /**
     * Test 2 de anadirSalaSesion, se espera un IllegalArgumentException.
     *  La sala es NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void anadirSalaSesion2() {
        System.out.println("Cine: Prueba anadirSalaSesion2");
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.anadirSalaSesion(null,sesion);
    }

    /**
     * Test 3 de anadirSalaSesion, se espera un IllegalArgumentException.
     *  La sesion es NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void anadirSalaSesion3(){
        System.out.println("Cine: Prueba anadirSalaSesion3");
        Sala sala= new Sala(7);
        cine.anadirSalaSesion(sala,null);
    }

    /**
     * Test 4 de anadirSalaSesion, se espera un IllegalArgumentException.
     *  La sala y la sesion son NULL
     */
    @Test (expected = IllegalArgumentException.class)
    public void anadirSalaSesion4() {
        System.out.println("Cine: Prueba anadirSalaSesion4");
        cine.anadirSalaSesion(null,null);
    }

    /**
     * Test 1 de mostrarCartelera, se muestra por pantalla la pelicula asignada
     */
    @Test
    public void mostrarCartelera1() throws IllegalAccessException {
        System.out.println("Cine: Prueba mostrarCartelera1");
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018,
                "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        cine.anadirPelicula(p1);
        cine.mostrarCartelera();
    }

    /**
     * Test 1 de mostrarCartelera, se espera un IllegalAccesException
     * No se han añadido peliculas al cine
     */
    @Test(expected = IllegalAccessException.class)
    public void mostrarCartelera2() throws IllegalAccessException {
        System.out.println("Cine: Prueba mostrarCartelera2");
        cine.mostrarCartelera();
    }
}