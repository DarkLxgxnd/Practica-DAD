package es.codeurjc.emperorsleague.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.jugadores = new ArrayList<>();
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
}
