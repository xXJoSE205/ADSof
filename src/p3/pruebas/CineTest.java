package p3.pruebas;

import org.junit.Before;
import org.junit.Test;
import p3.src.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CineTest {
    private Cine cine;

    @Before
    public void setUp() throws Exception {
        cine = new Cine("J & M","Calle bronce numero 5");
    }

    @Test
    public void getNombre() {
        System.out.println("Cine: Prueba getNombre");
        assertTrue(cine.getNombre().equals("J & M"));
    }

    @Test
    public void getDireccion() {
        System.out.println("Cine: Prueba getDireccion");
        assertTrue(cine.getDireccion().equals("Calle bronce numero 5"));
    }

    @Test
    public void getPeliculas() {
        System.out.println("Cine: Prueba getPeliculas");
        Pelicula p1= new Pelicula("Dragonball Evolution","James Wong",2009,"Cuenta la epica aventura de un joven que descubre su destino: salvar al mundo de las fuerzas malvadas", Genero.FANTASIA, 90);
        cine.anadirPelicula(p1);
        assertNotNull(cine.getPeliculas());
    }

    @Test
    public void getSalas() {
        System.out.println("Cine: Prueba getSalas");
        Sala s= new Sala(7);
        cine.annadirSala(s);
        assertNotNull(cine.getSalas());
    }

    @Test
    public void getEntradas() throws IllegalAccessException {
        System.out.println("Cine: Prueba getEntradas");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018, "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        cine.venderEntrada(sesion);
        assertNotNull(cine.getSalas());
    }

    @Test
    public void getRecaudacion() throws IllegalAccessException {
        System.out.println("Cine: Prueba getRecaudacion");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018, "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        cine.venderEntrada(sesion);
        assertTrue(cine.getRecaudacion()==9.20);
    }

    @Test
    public void setNombre() {
        System.out.println("Cine: Prueba setNombre");
        cine.setNombre("Zero Two");
        assertTrue(cine.getNombre()=="Zero Two");
    }

    @Test
    public void venderEntrada() throws IllegalAccessException {
        System.out.println("Cine: Prueba venderEntrada");
        Sala s= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018, "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(s);
        cine.anadirPelicula(p1);
        s.anadirSesion(sesion);
        assertTrue(cine.venderEntrada(sesion));
    }

    @Test
    public void removePelicula() {
        System.out.println("Cine: Prueba removePelicula");
        Sala sala= new Sala(7);
        Pelicula p1=new Pelicula("Zero Two", "Ichigo",2018, "Una historia de robots controlados por humanos",Genero.ACCION, 90);
        Sesion sesion= new Sesion(LocalDateTime.of(2018,12,03,15,20),p1);
        cine.annadirSala(sala);
        cine.anadirPelicula(p1);
        sala.anadirSesion(sesion);
        assertTrue(cine.removePelicula(p1)==1);
    }
}