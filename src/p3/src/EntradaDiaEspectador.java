/**
 * Esta clase contiene la informacion para saber si la entrada es del dia del espectador o no
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p3.src;

import java.time.DayOfWeek;

public class EntradaDiaEspectador extends Entrada{
    /** Descuento en euros*/
    private static final double DESCUENTO = 4;
    /** Dia de la semana para el dia del espectador*/
    private static final DayOfWeek DIA_ESPECTADOR = DayOfWeek.WEDNESDAY;

    /**
     * Constructor EntradaDiaEspectador
     *
     * @param sesion Sesion a la que pertenece la entrada
     * @param butaca Butaca a la que pertenece la entrada
     */
    public EntradaDiaEspectador(Sesion sesion, Butaca butaca) {
        super(sesion, butaca);
    }

    /**
     * Devuelve el precio de la entrada dependiendo de si es el dia del espectador o no
     *
     * @return Double, precio de la entrada
     */
    @Override
    public double getPrecio() {
        double precio = super.getPrecio();
        if(super.getSesion().getFecha().getDayOfWeek() == DIA_ESPECTADOR){
            precio = precio - DESCUENTO;
        }
        return precio;
    }
}
