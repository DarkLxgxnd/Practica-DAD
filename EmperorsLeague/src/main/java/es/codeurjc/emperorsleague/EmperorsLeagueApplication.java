package es.codeurjc.emperorsleague;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmperorsLeagueApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmperorsLeagueApplication.class, args);
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

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate jsonRabbitTemplate = new RabbitTemplate(connectionFactory);
		jsonRabbitTemplate.setMessageConverter(converter());
		return jsonRabbitTemplate;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory jsonRabbitListener(ConnectionFactory connectionFactory, SimpleRabbitListenerContainerFactoryConfigurer configurer) {
		SimpleRabbitListenerContainerFactory jsonRabbitListener = new SimpleRabbitListenerContainerFactory();
		configurer.configure(jsonRabbitListener, connectionFactory);
		jsonRabbitListener.setMessageConverter(converter());
		return jsonRabbitListener;
	}
}
