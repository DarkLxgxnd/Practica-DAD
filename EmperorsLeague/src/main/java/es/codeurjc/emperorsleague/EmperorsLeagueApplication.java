package es.codeurjc.emperorsleague;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmperorsLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmperorsLeagueApplication.class, args);
	}

	@Bean
	public Queue comunicacionQueue() {
		return new Queue("comunicaciones", false);
	}

	@Bean
	public Queue suscripcionQueue() {
		return new Queue("suscripciones", false);
	}
}
