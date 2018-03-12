package p3.src;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int identificador;
    private List<Butaca> butacas;
    private List<Sesion> sesiones;

    public Sala(int identificador) {
        this.identificador = identificador;
        this.butacas = new ArrayList<Butaca>();
        this.sesiones = new ArrayList<Sesion>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public List<Butaca> getButacas() {
        return butacas;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public boolean anadirSesion(Sesion sesion) {
        for(Sesion x: sesiones){
            if(x.getFecha().isEqual(sesion.getFecha())){
                return false;
            }
        }
        return this.sesiones.add(sesion);
    }

    public boolean anadirButaca(Butaca butaca) {
        for(Butaca x: butacas){
            if(x.getFila()== butaca.getFila()){
                if(x.getNumero()== butaca.getNumero()) {
                    return false;
                }
            }
        }
        return this.butacas.add(butaca);
    }
}
