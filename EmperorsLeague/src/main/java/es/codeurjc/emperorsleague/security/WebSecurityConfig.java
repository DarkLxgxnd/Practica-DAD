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
    	
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/partidos").permitAll();
        http.authorizeRequests().antMatchers("/equipos").permitAll();
        http.authorizeRequests().antMatchers("/clasificacion").permitAll();
        http.authorizeRequests().antMatchers("/partidos/{id_partido}").permitAll();
      


         // Private pages
        /*  http.authorizeRequests().antMatchers("/newbook").hasAnyRole("USER");
         http.authorizeRequests().antMatchers("/editbook/").hasAnyRole("USER");
         http.authorizeRequests().antMatchers("/removebook/").hasAnyRole("ADMIN"); Manager,user,admin
         http.authorizeRequests().antMatchers("/equipos/").hasAnyRole("USER");
         http.authorizeRequests().antMatchers("/equipos//jugadores/").hasAnyRole("USER"); */
         http.authorizeRequests().antMatchers("/partidos/new").hasAnyRole("ADMIN");
         http.authorizeRequests().antMatchers("//partidos/**/edit").hasAnyRole("ADMIN");
         http.authorizeRequests().antMatchers("//partidos/*/delete").hasAnyRole("ADMIN");
         http.authorizeRequests().antMatchers("/equipos/new").hasAnyRole("ADMIN");
         http.authorizeRequests().antMatchers("/equipos/*/edit").hasAnyRole("MANAGER");
         http.authorizeRequests().antMatchers("/equipos/*/delete").hasAnyRole("ADMIN");
         http.authorizeRequests().antMatchers("/equipos/*/jugadores/new").hasAnyRole("MANAGER");
         http.authorizeRequests().antMatchers("/equipos/*/jugadores/*/edit").hasAnyRole("MANAGER");
         http.authorizeRequests().antMatchers("/equipos/*/jugadores/*/delete").hasAnyRole("MANAGER");


         // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
}