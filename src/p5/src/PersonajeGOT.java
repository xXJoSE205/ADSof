package p5.src;

public class PersonajeGOT {
    private String nombre;
    private String casa;

    public PersonajeGOT(String nombre, String casa){
        this.nombre = nombre;
        this.casa = casa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCasa() {
        return casa;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Casa: "+casa+"\t";
    }
}
