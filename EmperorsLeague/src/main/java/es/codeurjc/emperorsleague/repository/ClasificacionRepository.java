package es.codeurjc.emperorsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Clasificacion;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
    
}