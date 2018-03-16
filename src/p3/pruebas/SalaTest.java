/**
 * Esta clase contiene el test de la clase Sala
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.pruebas;

import org.junit.Before;
import org.junit.Test;
import p3.src.*;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SalaTest {
    /**Sala general para el test*/
    private Sala sala;
    /**Sesion general para el test*/
    private Sesion ses;
    /**Pelicula general para el test*/
    private Pelicula peli;

    /**
     * Crea una sesion para realizar los test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sala = new Sala(5);
        peli = new Pelicula("A", "B", 2000, "C", Genero.COMEDIA, 137);
        ses = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), peli);
    }

     /**
     * Test constructor, se espera un IllegalArgumentException.
     *  El identificador es 0
     */

    @Test(expected = IllegalArgumentException.class)
    public void constructor(){
        System.out.println("Sala: Prueba constructor");
        Sala sala2 = new Sala(0);
    }

    /**
     * Test de getIdentificador, se espera como resultado un 5.
     */
    @Test
    public void getIdentificador() {
        System.out.println("Sala: Prueba getIdentificador");
        assertTrue(sala.getIdentificador() == 5);
    }

    /**
     * Test de getSesiones, se espera como resultado una lista distinta de NULL
     */
    @Test
    public void getSesiones() {
        System.out.println("Sala: Prueba getSesiones");
        assertNotNull(sala.getSesiones());
    }

    /**
     * Test 1 de anadirSesion, se espera como resultado una lista distinta de NULL
     */
    @Test
    public void anadirSesion1() {
        System.out.println("Sala: Prueba anadirSesion1");
        sala.anadirSesion(ses);
        assertNotNull(sala.getSesiones());
    }

    /**
     * Test 2 de anadirSesion, se espera un IllegalArgumentException
     * La sesion es null
     */
    @Test(expected = IllegalArgumentException.class)
    public void anadirSesion2() {
        System.out.println("Sala: Prueba anadirSesion2");
        sala.anadirSesion(null);
    }
}
