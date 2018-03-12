/**
 * Esta aplicacion comprueba la funcionalidad de las clases Alumno y Fecha
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p2.autoescuela;

import p2.alumno.Alumno;
import p2.fecha.Fecha;

/**
 * Tester del primer apartado de la P2
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class TesterAutoescuela {
    /**
     * Punto de entrada de la aplicación
     *
     * <p>Este método comprueba las fechas de matriculacion de los alumnos e imprime la información del primero</p>
     *
     * @param args Los argumentos de la línea de comandos. No se esperan argumentos.
     */
    public static void main(String[] args) {
        Alumno a1 = new Alumno("3141243T", "Jose", "Jimenez", 2016, 10, 3, "A");
        Alumno a2 = new Alumno("3141243T", "Sandra", "Goya", 2016, 22, 3, "C");
        Alumno a3 = new Alumno("3141243T", "Carlos", "Pascual", 2015, 2, 29, "E");
        Fecha c1 = a1.getFechaMatr();
        Fecha c2 = a2.getFechaMatr();
        Fecha c3 = a3.getFechaMatr();
        System.out.println("isValida <" + c1 + "> ? " + c1.isFechaValida());
        System.out.println("isValida <" + c2 + "> ? " + c2.isFechaValida());
        System.out.println("isValida <" + c3 + "> ? " + c3.isFechaValida());
        System.out.println("Datos de alumno 1: " + a1);
    }
}
