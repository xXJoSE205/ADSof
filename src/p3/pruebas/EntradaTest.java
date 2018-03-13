package p3.pruebas;

import p3.src.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class EntradaTest {
    private Entrada e;
    private Sesion ses;
    private Pelicula p;
    private Sala sala;
    private Butaca b;

    @Before
    public void setUp() throws Exception {
        p = new Pelicula("A", "B", 2018, "C", Genero.TERROR);
        sala = new Sala(1);
        ses = new Sesion(LocalDateTime.of(2018,03,13, 18, 00), p, sala);
        for(Butaca x: ses.getButacas()){
            if(x.isOcupada()==false){
                b = x;
                e = new EntradaDiaEspectador(ses, b);
                break;
            }
        }
    }

    @Test
    public void getPrecio1() {
        System.out.println("Entrada: Prueba getPrecio1");
        assertTrue(e.getPrecio() == Entrada.PRECIO);
    }

    @Test
    public void getSesion() {
        System.out.println("Entrada: Prueba getSesion");
        assertEquals(e.getSesion(), ses);
    }

    @Test
    public void getButaca() {
        System.out.println("Entrada: Prueba getButaca");
        assertEquals(e.getButaca(), b);
    }
}