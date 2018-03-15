package p3.pruebas;

import org.junit.Before;
import org.junit.Test;
import p3.src.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SalaTest {
    private Sala sala;
    private Sesion ses;
    private Pelicula peli;

    @Before
    public void setUp() throws Exception {
        sala = new Sala(5);
        peli = new Pelicula("A", "B", 2000, "C", Genero.COMEDIA, 137);
        ses = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), peli);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor(){
        System.out.println("Sala: Prueba constructor");
        Sala sala2 = new Sala(0);
    }

    @Test
    public void getIdentificador() {
        System.out.println("Sala: Prueba getIdentificador");
    }

    @Test
    public void getSesiones() {
    }

    @Test
    public void anadirSesion() {
    }
}