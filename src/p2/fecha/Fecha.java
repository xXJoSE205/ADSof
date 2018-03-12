/**
 * Esta clase contiene la información de una Fecha
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 *
 */
package p2.fecha;

public class Fecha {
    private int anyo;
    private int mes;
    private int dia;

    /**
     * Constructor del objeto Fecha
     *
     * @param anyo Año
     * @param mes Mes
     * @param dia Día
     */
    public Fecha(int anyo, int mes, int dia) {
        this.anyo = anyo;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Devuelve la fecha en un formato predefinido
     *
     * @return Cadena con la fecha, año-mes-día
     */
    @Override
    public String toString() {
        return anyo+"-"+mes+"-"+dia;
    }

    /**
     * Comprueba la validez de una fecha
     *
     * @return true si la fecha es válida, false en caso contrario
     */
    public boolean isFechaValida() {
        if(anyo<1 || mes<1 || mes>12 || dia<1){
            return false;
        }else if((mes == 1) ||(mes == 3) ||(mes == 5) ||(mes == 7) ||(mes == 8) ||(mes == 10) ||(mes == 12)){
            if(dia>31){
                return false;
            }
            return true;
        }else if((mes == 4) ||(mes == 6) ||(mes == 9) ||(mes == 11)){
            if(dia>30){
                return false;
            }
            return true;
        }else if(mes==2) {
            if(anyo % 4 == 0) {
                if (dia > 29) {
                    return false;
                }
                return true;
            }else if(dia > 28) {
                return false;
            }
            return true;
        }
        return false;
    }
}
