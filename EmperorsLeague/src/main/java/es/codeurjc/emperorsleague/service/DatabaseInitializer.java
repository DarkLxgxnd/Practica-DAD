package es.codeurjc.emperorsleague.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Clasificacion;
import es.codeurjc.emperorsleague.model.Usuario;
import es.codeurjc.emperorsleague.repository.ClasificacionRepository;
import es.codeurjc.emperorsleague.repository.UsuarioRepository;

@Service
public class DatabaseInitializer {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        clasificacionRepository.save(new Clasificacion());

	    usuarioRepository.save(new Usuario("admin", "", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
    }

    
}
