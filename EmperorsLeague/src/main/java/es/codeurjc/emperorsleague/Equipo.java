package es.codeurjc.emperorsleague;

import java.util.ArrayList;

public class Equipo {
	private int ptos;
	ArrayList<Jugador> jugadores;
	
	public Equipo(int ptos, ArrayList<Jugador> jugadores) {
		this.ptos = ptos;
		this.jugadores = jugadores;
	}

	public int getPtos() {
		return ptos;
	}

	public void setPtos(int ptos) {
		this.ptos = ptos;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
