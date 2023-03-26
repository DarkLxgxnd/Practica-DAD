package es.codeurjc.emperorsleague.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesReceiver {
    private List<Notificacion> notificaciones = new ArrayList<>();
    
    @RabbitListener(queues = "notificaciones", ackMode = "AUTO")
    public void receiveNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }
}
