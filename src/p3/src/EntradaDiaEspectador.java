package p3.src;


import java.time.DayOfWeek;

public class EntradaDiaEspectador extends Entrada{

    private static final DayOfWeek DIA_ESPECTADOR = DayOfWeek.WEDNESDAY;

    public EntradaDiaEspectador(Sesion sesion, Butaca butaca) {
        super(sesion, butaca);
    }

    @Override
    public double getPrecio() {
        double precio = super.getPrecio();
        if(super.getSesion().getFecha().getDayOfWeek() == DIA_ESPECTADOR){
            precio = precio-4;
        }
        return precio;
    }
}
