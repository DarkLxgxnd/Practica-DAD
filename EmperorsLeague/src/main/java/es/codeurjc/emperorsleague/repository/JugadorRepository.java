package es.codeurjc.emperorsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Jugador;

public interface JugadorRepository extends JpaRepository<Long, Jugador> {

}
