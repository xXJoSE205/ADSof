/**
 * Esta clase contiene el test de la clase Sesion
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.pruebas;

import p3.src.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SesionTest {
    /** Sesion general para el test*/
    private Sesion ses1;
    /** Pelicula general para el test*/
    private Pelicula peli;

    /**
     * Crea una pelicula y una sesion antes de cada test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        peli = new Pelicula("A", "B", 2018, "C", Genero.TERROR, 100);
        ses1 = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), peli);
    }

    /**
     * Test 1 del constructor, se espera un IllegalArgumentException.
     * La pelicula es nula
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor1(){
        System.out.println("Sesion: Prueba constructor1");
        Sesion ses2 = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), null);
    }

    /**
     * Test 2 del constructor, se espera un IllegalArgumentException.
     * La fecha es nula
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor2(){
        System.out.println("Sesion: Prueba constructor2");
        Sesion ses2 = new Sesion(null, peli);
    }

    /**
     * Test 3 del constructor, se espera un IllegalArgumentException.
     * La fecha y la pelicula son nulas
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor3(){
        System.out.println("Sesion: Prueba constructor3");
        Sesion ses2 = new Sesion(null, null);
    }

    /**
     * Test getFecha, se comprueba que la fecha del setUp no es nula
     */
    @Test
    public void getFecha() {
        System.out.println("Sesion: Prueba getFecha");
        assertNotNull(ses1.getFecha());
    }

    /**
     * Test 1 de setFecha, se comprueba que la fecha se ha modificado correctamente,
     */
    @Test
    public void setFecha1() {
        System.out.println("Sesion: Prueba setFecha1");
        assertTrue(ses1.setFecha(LocalDateTime.of(2018, 3, 15, 17, 30)));
    }

    /**
     * Test 2 de setFecha, se espera un IllegalArgumentException.
     * La fecha es nula
     */
    @Test(expected = IllegalArgumentException.class)
    public void setFecha2() {
        System.out.println("Sesion: Prueba setFecha2");
        ses1.setFecha(null);
    }

    /**
     * Test getFecha, se comprueba que la pelicula del setUp no es nula
     */
    @Test
    public void getPelicula() {
        System.out.println("Sesion: Prueba getPelicula");
        assertNotNull(ses1.getFecha());
    }

    /**
     * Test 1 de getSala, se crea una sala y se le asigna la sesion general.
     * Se comprueba que la sala de sesion no es nula
     */
    @Test
    public void getSala1() {
        Sala sala = new Sala(2);
        System.out.println("Sesion: Prueba getSala1");
        sala.anadirSesion(ses1);
        assertNotNull(ses1.getSala());
    }

    /**
     * Test 2 de getSala, se comprueba que la sala de la sesion general es nula
     */
    @Test
    public void getSala2() {
        System.out.println("Sesion: Prueba getSala2");
        assertNull(ses1.getSala());
    }

    /**
     * Test 1 de setSala, se comprueba que se ha asignado la sala correctamente
     */
    @Test
    public void setSala1() {
        Sala sala = new Sala(5);
        System.out.println("Sesion: Prueba setSala1");
        assertTrue(ses1.setSala(sala));
    }

    /**
     * Test 2 de setSala, se espera un IllegalArgumentException
     * La sala a asignar es nula
     */
    @Test(expected = IllegalArgumentException.class)
    public void setSala2() {
        Sala sala = null;
        System.out.println("Sesion: Prueba setSala2");
        ses1.setSala(sala);
    }

    /**
     * Test getButacas, se comprueba que la lista de butacas del setUp no es nula
     */
    @Test
    public void getButacas() {
        System.out.println("Sesion: Prueba getButacas");
        assertNotNull(ses1.getButacas());
    }

    /**
     * Test getButacasDisponible, se comprueba que las butacas disponibles son el total de butacas en la sesion.
     * No se ocupan butacas
     */
    @Test
    public void getButacasDisponibles() {
        System.out.println("Sesion: Prueba getButacasDisponibles");
        assertTrue(ses1.getButacasDisponibles() == Sesion.MAX_FILA*Sesion.MAX_COLUM);
    }

    /**
     * Test disminuirButacasDisponibles, se comprueba que se disminuye el numero de butacas disponibles.
     * Solo de disminuye una vez.
     */
    @Test
    public void disminuirButacasDisponibles() throws IllegalAccessException{
        System.out.println("Sesion: Prueba disminuirButacasDisponibles");
        assertTrue(ses1.disminuirButacasDisponibles());
    }
}