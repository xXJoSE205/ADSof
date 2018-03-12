package p3.src;

import java.util.List;

public class Sala {
    private int identificador;
    private List<Butaca> butacas;
    private List<Sesion> sesiones;

    public Sala(int identificador, List<Butaca> butacas, List<Sesion> sesiones) {
        this.identificador = identificador;
        this.butacas = butacas;
        this.sesiones = sesiones;
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
