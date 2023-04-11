package es.codeurjc.emperorsleague.events;

import java.io.Serializable;

public class Notificacion implements Serializable {
    private String equipo;
    private String titulo;
    private String contenido;

    public Notificacion() {
    }

    public Notificacion(String equipo, String titulo, String contenido) {
        this.equipo = equipo;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getTitulo() {
        return titulo;        
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
