package es.codeurjc.emperorsleague.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipo {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    private String nombre;
    private int puntos;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @ManyToMany(mappedBy = "equiposParticipantes")
    private List<Partido> partidos;

    @ManyToOne
    private Clasificacion clasificacion;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
}
