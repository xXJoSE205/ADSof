package p5.src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class GrafoGOT<PersonajeGOT> extends GrafoNoDirigido<PersonajeGOT>{

    public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception{
        BufferedReader bufferVertices = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
        BufferedReader bufferArcos = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));
        String line;

        while((line = bufferVertices.readLine()) != null){
            String split1[] = line.split(",");
            p5.src.PersonajeGOT pers = new p5.src.PersonajeGOT(split1[1], split1[2]);
            Vertice<PersonajeGOT> ver = this.addVertice(Integer.parseInt(split1[0]), (PersonajeGOT) pers);
        }

        while((line = bufferArcos.readLine()) != null){
            String split2[] = line.split(",");
            this.addArco(vertices.get(Integer.parseInt(split2[0])),
                    vertices.get(Integer.parseInt(split2[1])), Double.parseDouble(split2[2]));
        }
    }

    public Vertice<PersonajeGOT> getVertice(String nombre){
    }

    public List<String> casas(){
    }

    public List<String> miembrosCasa(String casa){
    }

    public Map<String, Integer> gradoPersonajes(){
    }

    public Map<String, Integer> gradoPonderadoPersonajes(){
    }

    public Map<String, Integer> personajesRelevantes(){
    }
}
