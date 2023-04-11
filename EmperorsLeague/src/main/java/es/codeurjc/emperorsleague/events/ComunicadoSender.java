package es.codeurjc.emperorsleague.events;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComunicadoSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendComunicado(String titulo, String contenido) {
        Comunicado comunicado = new Comunicado(titulo, contenido);
        
        rabbitTemplate.convertAndSend("comunicados", comunicado);
    }
}
