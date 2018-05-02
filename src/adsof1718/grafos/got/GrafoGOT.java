package adsof1718.grafos.got;

import adsof1718.grafos.GrafoNoDirigido;
import adsof1718.grafos.Vertice;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GrafoGOT<PersonajeGOT> extends GrafoNoDirigido<PersonajeGOT> {

    public static void main(String[] args){
        List<String>  listas;
        Map<String, Integer> mapas;
        Vertice<adsof1718.grafos.got.PersonajeGOT> personaje;

        try {
            GrafoGOT<adsof1718.grafos.got.PersonajeGOT> g = new GrafoGOT<>("got-s01-vertices.csv", "got-s01-arcos.csv");
            System.out.println(g);


            System.out.println("\nPersonaje buscado:");
            personaje = g.getVertice("Tyrion Lannister");
            System.out.println(personaje);

            listas = g.casas();
            System.out.println("\nDistintas casas:");
            System.out.println(listas);

            listas = g.miembrosCasa("Stark");
            System.out.println("\nMiembros de la casa Stark:");
            System.out.println(listas.toString());
            listas = g.miembrosCasa("Lannister");
            System.out.println("\nMiembros de la casa Lannister:");
            System.out.println(listas.toString());

            mapas = g.gradoPersonajes();
            System.out.println("\nVecinos de cada personaje:");
            System.out.println(mapas);

            System.out.println("");
            mapas = g.gradoPonderadoPersonajes();
            System.out.println("Peso Ponderado:");
            System.out.println(mapas);

            System.out.println("");
            mapas = g.personajesRelevantes();
            System.out.println("Personajes relevantes:");
            System.out.println(mapas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception{
        BufferedReader bufferVertices = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
        String line;

        while((line = bufferVertices.readLine()) != null){
            String split1[] = line.split(",");
            adsof1718.grafos.got.PersonajeGOT pers = new adsof1718.grafos.got.PersonajeGOT(split1[1], split1[2]);
            if(this.addVertice(Integer.parseInt(split1[0]), (PersonajeGOT)pers)==null){
                throw new NullPointerException("Error al crear el personaje");
            }
        }
        bufferVertices.close();

        BufferedReader bufferArcos = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));

        while((line = bufferArcos.readLine()) != null){
            String split2[] = line.split(",");
            this.addArco(vertices.get(Integer.parseInt(split2[0])),
                    vertices.get(Integer.parseInt(split2[1])), Double.parseDouble(split2[2]));
        }
        bufferArcos.close();
    }

    public Vertice<PersonajeGOT> getVertice(String nombre){
        List<Vertice<PersonajeGOT>> pers;
        Vertice<PersonajeGOT> personaje;

        pers = vertices.entrySet().stream()
                .filter(map -> ((adsof1718.grafos.got.PersonajeGOT) map.getValue().getDatos()).getNombre().equals(nombre))
                .map(Map.Entry::getValue).collect(Collectors.toList());

        personaje = pers.get(0);

        return personaje;
    }

    public List<String> casas(){
        Set<String> setLista;

        setLista = vertices.entrySet().stream()
                .map(map-> ((adsof1718.grafos.got.PersonajeGOT)map.getValue().getDatos()).getCasa())
                .collect(Collectors.toSet());

        setLista.remove("null");

        return new ArrayList<>(setLista);
    }

    public List<String> miembrosCasa(String casa){
        List<String> lista;

        lista = vertices.entrySet().stream()
                .filter(map -> ((adsof1718.grafos.got.PersonajeGOT) map.getValue().getDatos()).getCasa().equals(casa))
                .map(map-> ((adsof1718.grafos.got.PersonajeGOT)map.getValue().getDatos()).getNombre())
                .collect(Collectors.toList());

        return lista;
    }

    public Map<String, Integer> gradoPersonajes(){
        Map<String, Integer> grados = new HashMap<>();

        aristas.forEach((k1, v1)-> grados.put(((adsof1718.grafos.got.PersonajeGOT)vertices.get(k1).getDatos()).getNombre(), v1.size()));

        return grados;
    }

    public Map<String, Integer> gradoPonderadoPersonajes(){
        Map<String, Integer> gradosPon = new HashMap<>();

        vertices.forEach((k1, v1)->{
            Map<Integer, Double> map = aristas.get(k1);
            final int[] grados = {0};

            map.forEach((k2, v2)-> grados[0] += v2);

            gradosPon.put(((adsof1718.grafos.got.PersonajeGOT)v1.getDatos()).getNombre(), grados[0]);
        });

        return gradosPon;
    }

    public Map<String, Integer> personajesRelevantes(){
        Map<String, Integer> mapa = gradoPonderadoPersonajes();
        final double[] media = {0};

        mapa.forEach((k, v)-> media[0] += v);

        media[0] /= vertices.size();

        mapa = mapa.entrySet().stream()
                .filter(map -> map.getValue()>=media[0])
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return mapa;
    }
}
