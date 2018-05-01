package p5.src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GrafoGOT<PersonajeGOT> extends GrafoNoDirigido<PersonajeGOT>{

    public static void main(String[] args){
        try {
            GrafoGOT<p5.src.PersonajeGOT> g = new GrafoGOT<>("got-s01-vertices.csv", "got-s01-arcos.csv");
            System.out.println(g);

            List<String>  listas;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception{
        BufferedReader bufferVertices = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
        String line;

        while((line = bufferVertices.readLine()) != null){
            String split1[] = line.split(",");
            p5.src.PersonajeGOT pers = new p5.src.PersonajeGOT(split1[1], split1[2]);
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
        Vertice<PersonajeGOT> pers;

        pers = (Vertice<PersonajeGOT>) vertices.entrySet().stream()
                .filter(map -> ((p5.src.PersonajeGOT) map.getValue().getDatos()).getNombre().equals(nombre))
                .map(Map.Entry::getValue);

        return pers;
    }

    public List<String> casas(){
        Set<String> setLista = new TreeSet<>();

        setLista.add(vertices.entrySet().stream()
                .map(map-> ((p5.src.PersonajeGOT)map.getValue().getDatos()).getCasa())
                .collect(Collectors.joining()));

        setLista.remove("null");

        return new ArrayList<>(setLista);
    }

    public List<String> miembrosCasa(String casa){
        List<String> lista = new ArrayList<>();

        lista.add(vertices.entrySet().stream()
                .filter(map -> ((p5.src.PersonajeGOT) map.getValue().getDatos()).getCasa().equals(casa))
                .map(map-> ((p5.src.PersonajeGOT)map.getValue().getDatos()).getNombre())
                .collect(Collectors.joining()));

        return lista;
    }

    public Map<String, Integer> gradoPersonajes(){
        Map<String, Integer> grados = new HashMap<>();

        aristas.forEach((k1, v1)-> grados.put(((p5.src.PersonajeGOT)vertices.get(k1).getDatos()).getNombre(), v1.size()));

        return grados;
    }

    public Map<String, Integer> gradoPonderadoPersonajes(){
        Map<String, Integer> gradosPon = new HashMap<>();

        vertices.forEach((k1, v1)->{
            if(aristas.get(k1)==null){
                gradosPon.put(((p5.src.PersonajeGOT)v1.getDatos()).getNombre(), 0);
            }else {
                Map<Integer, Double> map = aristas.get(k1);
                final int[] grados = {0};

                map.forEach((k2, v2)-> grados[0] += v2);

                gradosPon.put(((p5.src.PersonajeGOT)v1.getDatos()).getNombre(), grados[0]);
            }
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
