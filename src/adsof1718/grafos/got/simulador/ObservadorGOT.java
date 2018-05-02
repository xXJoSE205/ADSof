package adsof1718.grafos.got.simulador;

import adsof1718.grafos.got.PersonajeGOT;
import java.util.List;

public class ObservadorGOT extends Observador {
    private PersonajeGOT pers;

    public ObservadorGOT(SimuladorGOT s, PersonajeGOT p){
        super(s);
        this.pers = p;
    }

    public void actualizar(){
        SimuladorGOT simulador = (SimuladorGOT) super.sujeto;

        PersonajeGOT origen = simulador.getOrigen();
        List<PersonajeGOT> destinos = simulador.getDestinos();

        //...
    }
}
