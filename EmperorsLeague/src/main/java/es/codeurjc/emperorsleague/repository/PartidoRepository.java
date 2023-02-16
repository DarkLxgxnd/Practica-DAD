package es.codeurjc.emperorsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

}
