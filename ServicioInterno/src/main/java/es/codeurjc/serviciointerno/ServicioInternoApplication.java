package es.codeurjc.serviciointerno;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicioInternoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServicioInternoApplication.class, args);
	}

	@Bean
	public Queue comunicadosQueue() {
		return new Queue("comunicados", false);
	}

	@Bean
	public Queue partidosQueue() {
		return new Queue("partidos", false);
	}

	@Bean
	public Queue notificacionesQueue() {
		return new Queue("notificaciones", false);
	}
}

