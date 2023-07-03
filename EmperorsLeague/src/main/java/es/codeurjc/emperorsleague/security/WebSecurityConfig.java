package es.codeurjc.emperorsleague.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
	RepositoryUserDetailsService userDetailsService;

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// Páginas públicas
        http.authorizeHttpRequests().antMatchers("/").permitAll();
        http.authorizeHttpRequests().antMatchers("/login").permitAll();
        http.authorizeHttpRequests().antMatchers("/login/error").permitAll();
        http.authorizeHttpRequests().antMatchers("/logout").permitAll();
        http.authorizeHttpRequests().antMatchers("/signup").permitAll();
        http.authorizeHttpRequests().antMatchers("/partidos").permitAll();
        http.authorizeHttpRequests().antMatchers("/equipos").permitAll();
        http.authorizeHttpRequests().antMatchers("/clasificacion").permitAll();
        http.authorizeHttpRequests().antMatchers("/partidos/*").permitAll();

        // Páginas privadas
        http.authorizeHttpRequests().antMatchers("/partidos/new").hasAnyRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/partidos/*/edit").hasAnyRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/partidos/*/delete").hasAnyRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/equipos/new").hasAnyRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/equipos/*/edit").hasAnyRole("MANAGER");
        http.authorizeHttpRequests().antMatchers("/equipos/*/delete").hasAnyRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/equipos/*/jugadores/new").hasAnyRole("MANAGER");
        http.authorizeHttpRequests().antMatchers("/equipos/*/jugadores/*/edit").hasAnyRole("MANAGER");
        http.authorizeHttpRequests().antMatchers("/equipos/*/jugadores/*/delete").hasAnyRole("MANAGER");

        // Login
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/login/error");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
}