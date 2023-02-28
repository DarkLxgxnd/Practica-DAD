package es.codeurjc.emperorsleague.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Clasificacion;
import es.codeurjc.emperorsleague.repository.ClasificacionRepository;

@Service
public class DatabaseInitializer {
    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @PostConstruct
    public void init() {
        Clasificacion clasificacion = new Clasificacion();
        clasificacionRepository.save(clasificacion);
    }
}
