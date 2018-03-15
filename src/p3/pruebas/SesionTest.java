package p3.pruebas;

import p3.src.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SesionTest {
    private Sesion ses1;
    private Pelicula peli;

    @Before
    public void setUp() throws Exception {
        peli = new Pelicula("A", "B", 2018, "C", Genero.TERROR, 100);
        ses1 = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), peli);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor1(){
        System.out.println("Sesion: Prueba constructor1");
        Sesion ses2 = new Sesion(LocalDateTime.of(2018, 3, 15, 17, 30), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor2(){
        System.out.println("Sesion: Prueba constructor2");
        Sesion ses2 = new Sesion(null, peli);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor3(){
        System.out.println("Sesion: Prueba constructor3");
        Sesion ses2 = new Sesion(null, null);
    }

    @Test
    public void getFecha() {
        System.out.println("Sesion: Prueba getFecha");
        assertNotNull(ses1.getFecha());
    }

    @Test
    public void setFecha1() {
        System.out.println("Sesion: Prueba setFecha1");
        assertTrue(ses1.setFecha(LocalDateTime.of(2018, 3, 15, 17, 30)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFecha2() {
        System.out.println("Sesion: Prueba setFecha2");
        ses1.setFecha(null);
    }

    @Test
    public void getPelicula() {
        System.out.println("Sesion: Prueba getPelicula");
        assertNotNull(ses1.getFecha());
    }

    @Test
    public void getSala1() {
        Sala sala = new Sala(2);
        System.out.println("Sesion: Prueba getSala1");
        ses1.setSala(sala);
        assertNotNull(ses1.getSala());
    }

    @Test
    public void getSala2() {
        System.out.println("Sesion: Prueba getSala2");
        assertNull(ses1.getSala());
    }

    @Test
    public void setSala1() {
        Sala sala = new Sala(5);
        System.out.println("Sesion: Prueba setSala1");
        assertTrue(ses1.setSala(sala));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSala2() {
        Sala sala = null;
        System.out.println("Sesion: Prueba setSala2");
        ses1.setSala(sala);
    }

    @Test
    public void getButacas() {
        System.out.println("Sesion: Prueba getButacas");
        assertNotNull(ses1.getButacas());
    }

    @Test
    public void getButacasDisponibles() {
        System.out.println("Sesion: Prueba getButacasDisponibles");
        assertTrue(ses1.getButacasDisponibles() == Sesion.MAX_FILA*Sesion.MAX_COLUM);
    }

    @Test
    public void disminuirButacasDisponibles() throws IllegalAccessException{
        System.out.println("Sesion: Prueba disminuirButacasDisponibles");
        assertTrue(ses1.disminuirButacasDisponibles());
    }
}