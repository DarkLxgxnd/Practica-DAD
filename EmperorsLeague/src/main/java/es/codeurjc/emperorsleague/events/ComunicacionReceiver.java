package es.codeurjc.emperorsleague.events;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ComunicacionReceiver {
    @RabbitListener(queues = "comunicaciones", ackMode = "AUTO")
    public Object receiveComunicacion(Comunicacion comunicacion) {
        return comunicacion;
    }
}
