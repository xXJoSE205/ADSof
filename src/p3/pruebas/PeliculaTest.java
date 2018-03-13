package p3.pruebas;

import p3.src.Pelicula;
import p3.src.Genero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliculaTest {
    private Pelicula p1;

    @Before
    public void setUp() throws Exception {
        p1 = new Pelicula("Dragonball Evolution","James Wong",2009,"Cuenta la epica aventura de un joven que descubre su destino: salvar al mundo de las fuerzas malvadas", Genero.FANTASIA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor() {
        System.out.println("Pelicula: Prueba constructor");
        Pelicula p2 = new Pelicula("A","B",496,"C", Genero.ACCION);
    }

    @Test
    public void getTitulo() {
        System.out.println("Pelicula: Prueba geTitulo");
        assertTrue(p1.getTitulo().equals("Dragonball Evolution"));
    }

    @Test
    public void getDirector() {
        System.out.println("Pelicula: Prueba getDirector");
        assertTrue(p1.getDirector().equals("James Wong"));
    }

    @Test
    public void getAnno() {
        System.out.println("Pelicula: Prueba getAnno");
        assertTrue(p1.getAnno() == 2009);
    }

    @Test
    public void getSinopsis() {
        System.out.println("Pelicula: Prueba getSinopsis");
        assertTrue(p1.getSinopsis().equals("Cuenta la epica aventura de un joven que descubre su destino: salvar al mundo de las fuerzas malvadas"));
    }

    @Test
    public void getGenero() {
        System.out.println("Pelicula: Prueba getGenero");
        assertTrue(p1.getGenero() == Genero.FANTASIA);
    }

    @Test
    public void mostarInformacion() {
        System.out.println("Pelicula: Prueba mostrarInformacion");
        p1.mostarInformacion();
    }
}