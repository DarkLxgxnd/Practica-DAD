package es.codeurjc.emperorsleague.events;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendNotificacion(String equipo, String titulo, String contenido) {
        Notificacion notificacion = new Notificacion(equipo, titulo, contenido);
        
        rabbitTemplate.convertAndSend("notificaciones", notificacion);
    }
}
