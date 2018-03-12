package p3.src;

import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime fecha;
    private Pelicula pelicula;

    public Sesion(LocalDateTime fecha, Pelicula pelicula) {
        this.fecha = fecha;
        this.pelicula = pelicula;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public boolean anadirPelicula(Pelicula pelicula) {
        if(this.pelicula == pelicula){
            return false;
        }
        this.pelicula=pelicula;
        return true;
    }
}
