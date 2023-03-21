package es.codeurjc.emperorsleague.events;

public class Comunicacion {
    private String titulo;
    private String contenido;

    public Comunicacion(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;        
    }

    public String getContenido() {
        return contenido;
    }
}
