package es.codeurjc.emperorsleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Jugador;

@CacheConfig(cacheNames = "emperorsleague")
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    @CacheEvict(allEntries = true)
    Jugador save(Jugador jugador);

    @CacheEvict(allEntries = true)
    Jugador delete(long id);

    @Cacheable
    Optional<Jugador> findById(long id);
    
    @Cacheable
    List<Jugador> findAll();
}
