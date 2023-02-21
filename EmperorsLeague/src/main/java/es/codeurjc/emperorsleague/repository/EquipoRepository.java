package es.codeurjc.emperorsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
}
