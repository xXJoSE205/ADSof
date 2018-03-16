/**
 * Esta clase contiene el test de la clase Pelicula
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.pruebas;

import p3.src.Pelicula;
import p3.src.Genero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeliculaTest {
    /** Pelicula general para el test*/
    private Pelicula p1;

    /**
     * Crea una pelicula nueva antes de cada test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        p1 = new Pelicula("Dragonball Evolution","James Wong",2009,"Cuenta la epica "
                +"aventura de un joven que descubre su destino: salvar al mundo de las fuerzas malvadas",
                Genero.FANTASIA, 90);
    }

    /**
     * Test 1 del constructor, se espera un IllegalArgumentException.
     * El año es menor que 1900
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor1() {
        System.out.println("Pelicula: Prueba constructor1");
        Pelicula p2 = new Pelicula("A","B",496,"C", Genero.ACCION, 120);
    }

    /**
     * Test 2 del constructor, se espera un IllegalArgumentException.
     * La duracion es menor que 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor2() {
        System.out.println("Pelicula: Prueba constructor2");
        Pelicula p2 = new Pelicula("A","B",1996,"C", Genero.ACCION, -56);
    }

    /**
     * Test 1 del constructor, se espera un IllegalArgumentException.
     * El año es menor que 1900 y la duracion es menor que 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructor3() {
        System.out.println("Pelicula: Prueba constructor3");
        Pelicula p2 = new Pelicula("A","B",496,"C", Genero.ACCION, -56);
    }

    /**
     * Test de getTitulo, se comprueba que el nombre del setUp es igual a "Dragonball Evolution"
     */
    @Test
    public void getTitulo() {
        System.out.println("Pelicula: Prueba geTitulo");
        assertEquals(p1.getTitulo(), "Dragonball Evolution");
    }

    /**
     * Test de getDirector, se comprueba que el director del setUp es igual a "James Wong"
     */
    @Test
    public void getDirector() {
        System.out.println("Pelicula: Prueba getDirector");
        assertEquals(p1.getDirector(), "James Wong");
    }

    /**
     * Test de getAnno, se comprueba que el año del setUp es igual a 2009
     */
    @Test
    public void getAnno() {
        System.out.println("Pelicula: Prueba getAnno");
        assertTrue(p1.getAnno() == 2009);
    }

    /**
     * Test de getSinopsis, se comprueba que la sinopsis del setUp es igual a
     * "Cuenta la epica aventura de un joven que descubre su destino: salvar al mundo de las fuerzas malvadas"
     */
    @Test
    public void getSinopsis() {
        System.out.println("Pelicula: Prueba getSinopsis");
        assertTrue(p1.getSinopsis().equals("Cuenta la epica aventura de un joven que descubre su destino: "
                +"salvar al mundo de las fuerzas malvadas"));
    }

    /**
     * Test de getGenero, se comprueba que el genero del setUp es igual a FANSTASIA
     */
    @Test
    public void getGenero() {
        System.out.println("Pelicula: Prueba getGenero");
        assertTrue(p1.getGenero() == Genero.FANTASIA);
    }

    /**
     * Test de getDuracion, se comprueba que la duracion del setUp es igual a 90 minutos
     */
    @Test
    public void getDuracion() {
        System.out.println("Pelicula: Prueba getDuracion");
        assertTrue(p1.getDuracion() == 90);
    }

    /**
     * Test de mostrarInformacion, se imprime por pantalla todos los datos de la pelicula
     */
    @Test
    public void mostarInformacion() {
        System.out.println("Pelicula: Prueba mostrarInformacion");
        p1.mostarInformacion();
    }
}