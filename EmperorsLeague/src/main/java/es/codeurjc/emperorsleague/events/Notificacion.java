package es.codeurjc.emperorsleague.events;

public class Notificacion {
    private String equipo;
    private String titulo;
    private String contenido;

    public Notificacion(String equipo, String titulo, String contenido) {
        this.equipo = equipo;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getTitulo() {
        return titulo;        
    }

    public String getContenido() {
        return contenido;
    }
}
