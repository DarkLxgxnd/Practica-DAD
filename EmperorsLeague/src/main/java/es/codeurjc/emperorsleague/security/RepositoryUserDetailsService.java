package es.codeurjc.emperorsleague.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Usuario;
import es.codeurjc.emperorsleague.repository.UsuarioRepository;

@Service
public class RepositoryUserDetailsService implements UserDetailsService {
    @Autowired
	private UsuarioRepository usuarioRepository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombre(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<GrantedAuthority> roles = new ArrayList<>();

		for (String rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + rol));
		}

        return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getContrasena(), roles);
    }
}
