package p3.pruebas;

import p3.src.Butaca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ButacaTest {
    private Butaca b1;

    @Before
    public void setUp() throws Exception {
        b1 = new Butaca(2, 5);
    }

    @Test
    public void getFila1() {
        System.out.println("Butaca: Prueba geFila1");
        assertTrue(b1.getFila() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFila2() {
        System.out.println("Butaca: Prueba getFila2");
        Butaca b2 = new Butaca(-4, 5);
    }

    @Test
    public void getNumero1() {
        System.out.println("Butaca: Prueba geNumero1");
        assertTrue(b1.getNumero() == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNumero2() {
        System.out.println("Butaca: Prueba geNumero2");
        Butaca b2 = new Butaca(2, 0);
    }

    @Test
    public void isOcupada1() {
        System.out.println("Butaca: Prueba isOcupada1");
        assertFalse(b1.isOcupada());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isOcupada2() {
        System.out.println("Butaca: Prueba isOcupada2");
        Butaca b2 = new Butaca(-6, -3);
    }

    @Test
    public void setOcupada1() {
        System.out.println("Butaca: Prueba setOcupada1");
        b1.setOcupada(true);
        assertTrue(b1.isOcupada());
    }

    @Test
    public void setOcupada2() {
        System.out.println("Butaca: Prueba setOcupada2");
        b1.setOcupada(false);
        assertFalse(b1.isOcupada());
    }
}