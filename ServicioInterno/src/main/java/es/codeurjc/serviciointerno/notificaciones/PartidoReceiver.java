package es.codeurjc.serviciointerno.notificaciones;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoReceiver {
    @Autowired
    NotificacionesSender notificacionesSender;

    @RabbitListener(queues = "partidos", ackMode = "AUTO")
    public void receivePartido(PartidoInfo partidoInfo) {
        notificacionesSender.sendNotificaciones(partidoInfo);
    }
}
