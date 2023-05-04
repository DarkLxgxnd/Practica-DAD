
package es.codeurjc.emperorsleague.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Clasificacion;

@CacheConfig(cacheNames = "emperorsleague")
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
    @CacheEvict(allEntries = true)
    Clasificacion save(Clasificacion clasificacion);

    @CacheEvict(allEntries = true)
    Clasificacion delete(long id);

    @Cacheable
    Clasificacion getReferenceById(long id);
}