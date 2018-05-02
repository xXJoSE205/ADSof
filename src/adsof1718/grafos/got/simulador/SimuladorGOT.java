package adsof1718.grafos.got.simulador;

import adsof1718.grafos.Vertice;
import adsof1718.grafos.got.*;
import java.util.List;
import java.util.Map;

public class SimuladorGOT extends Sujeto {
    private GrafoGOT<PersonajeGOT> grafo;
    private PersonajeGOT origen;
    private List<PersonajeGOT> destinos;
    private int interacciones = 0;

    public SimuladorGOT(GrafoGOT<PersonajeGOT> g){
        this.grafo = g;
    }

    public PersonajeGOT getOrigen() {
        return origen;
    }

    public List<PersonajeGOT> getDestinos() {
        return destinos;
    }

    public void interaccion(String nombre){
        Vertice<PersonajeGOT> u = grafo.getVertice(nombre);
        List<Vertice<PersonajeGOT>> v = grafo.getVecinosDe(u);
        double p, peso, pesoTotal, r;
        Map<String, Integer> aux = grafo.gradoPonderadoPersonajes();

        pesoTotal = (double) aux.get(nombre);
        for(Vertice<PersonajeGOT> vAux: v){
            peso = grafo.getPesoDe(u, vAux);
            r = Math.random();
            p = peso/pesoTotal;

            if(r < p){
                //notificar interaccion
            }
        }
    }
}
