package es.codeurjc.emperorsleague;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
@EnableCaching
@EnableHazelcastHttpSession
public class EmperorsLeagueApplication {
	private static final Log LOG = LogFactory.getLog(EmperorsLeagueApplication.class);
	
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

	@Bean
    public CacheManager cacheManager() {
    	LOG.info("Activating cache...");
    	return new ConcurrentMapCacheManager("equipos", "jugadores", "partidos");
    }

	@Bean
    public Config config() {
        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Arrays.asList("docker-web-1", "docker-web-2"));

        return config;
    }
}