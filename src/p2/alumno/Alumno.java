/**
 * Esta clase contiene la información de un Alumno
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 *
 */
package p2.alumno;

import p2.fecha.Fecha;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private Fecha fechaMatr;
    private String tipoCarnet;

    /**
     * Constructor del objeto Alumno, crea una Fecha nueva con los parámetros anyo, mes y dia
     *
     * @param dni DNI del Alumno
     * @param nombre Nombre del Alumno
     * @param apellidos Apellidos del Alumno
     * @param anyo Año de matriculación
     * @param mes Mes de matriculación
     * @param dia Día de matriculación
     * @param tipoCarnet Carnet que tiene el Alumno
     */
    public Alumno(String dni, String nombre, String apellidos, int anyo, int mes, int dia, String tipoCarnet) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaMatr = new Fecha(anyo, mes, dia);
        this.tipoCarnet = tipoCarnet;
    }

    /**
     * Devuelve la fecha de matriculación del alumno
     *
     * @return Fecha, año-mes-dia
     */
    public Fecha getFechaMatr() {
        return fechaMatr;
    }

    /**
     * Devuelve toda la información del alumno
     *
     * @return Cadena con la información del alumno
     */
    @Override
    public String toString() {
        return "\n\tNombre: "+nombre+"\n\tApellido: "+apellidos+"\n\tDNI: "+dni+"\n\tFecha Matricula: "+
                fechaMatr.toString()+"\n\tTipo Carnet: "+tipoCarnet;
    }
}