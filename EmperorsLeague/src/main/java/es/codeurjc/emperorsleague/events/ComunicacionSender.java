package es.codeurjc.emperorsleague.events;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComunicacionSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendComunicacion(String titulo, String contenido) {
        Comunicacion comunicacion = new Comunicacion(titulo, contenido);
        
        rabbitTemplate.convertAndSend("comunicaciones", comunicacion);
    }
}
